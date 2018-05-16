package ex10.pyrmont.startup;

import ex10.pyrmont.core.SimpleWrapper;
import ex10.pyrmont.core.SimpleContextConfig;
import ex10.pyrmont.realm.SimpleRealm;

import org.apache.catalina.Connector;
import org.apache.catalina.Context;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.Loader;
import org.apache.catalina.Realm;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.http.HttpConnector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.deploy.LoginConfig;
import org.apache.catalina.deploy.SecurityCollection;
import org.apache.catalina.deploy.SecurityConstraint;
import org.apache.catalina.loader.WebappLoader;

public final class Bootstrap1 {
  public static void main(String[] args) {

  //invoke: http://localhost:8080/Modern or  http://localhost:8080/Primitive

    System.setProperty("catalina.base", System.getProperty("user.dir"));
    Connector connector = new HttpConnector();
    Wrapper wrapper1 = new SimpleWrapper();
    wrapper1.setName("Primitive");
    wrapper1.setServletClass("PrimitiveServlet");
    Wrapper wrapper2 = new SimpleWrapper();
    wrapper2.setName("Modern");
    wrapper2.setServletClass("ModernServlet");

    Context context = new StandardContext();
    // StandardContext's start method adds a default mapper
    context.setPath("/myApp");
    context.setDocBase("myApp");

    //这章的进入点在这里，通过一个监听器来安装BasicAuthenticator这个验证安全性的阀门
    LifecycleListener listener = new SimpleContextConfig();
    ((Lifecycle) context).addLifecycleListener(listener);

    context.addChild(wrapper1);
    context.addChild(wrapper2);
    // for simplicity, we don't add a valve, but you can add
    // valves to context or wrapper just as you did in Chapter 6

    Loader loader = new WebappLoader();
    context.setLoader(loader);
    // context.addServletMapping(pattern, name);
    context.addServletMapping("/Primitive", "Primitive");
    context.addServletMapping("/Modern", "Modern");
    // add ContextConfig. This listener is important because it configures
    // StandardContext (sets configured to true), otherwise StandardContext
    // won't start

    // add constraint
    SecurityCollection securityCollection = new SecurityCollection();
    securityCollection.addPattern("/"); //对哪个URL进行安全检查
    securityCollection.addMethod("GET"); //安全检查使用的方法

    SecurityConstraint constraint = new SecurityConstraint();
    constraint.addCollection(securityCollection);
    constraint.addAuthRole("manager"); //设置哪种角色可以访问受限资源
    LoginConfig loginConfig = new LoginConfig();
    loginConfig.setRealmName("Simple Realm");
    // add realm
    Realm realm = new SimpleRealm();

    context.setRealm(realm); //所有容器都有
    context.addConstraint(constraint); //context中才有
    context.setLoginConfig(loginConfig);//context中才有

    connector.setContainer(context);

    try {
      connector.initialize();
      ((Lifecycle) connector).start();
      ((Lifecycle) context).start();

      // make the application wait until we press a key.
      System.in.read();
      ((Lifecycle) context).stop();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}