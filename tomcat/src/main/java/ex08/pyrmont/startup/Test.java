package ex08.pyrmont.startup;

import org.apache.catalina.logger.SystemErrLogger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Test {
    //Classloader获取资源时不能带斜杠。
    //class获取的时候，带斜杠就是从根目录
    public static final String DEFAULT_RESOURCE =
     //       "/org/apache/catalina/util/CharsetMapperDefault.properties";
    "/CharsetMapperDefault.properties";
    //"/ex08/pyrmont/Resources/CharsetMapperDefault.properties";

    public static void main(String[] args) {
        Test test = new Test();
        test.getResource(DEFAULT_RESOURCE);
    }

    public void getResource(String name){

        //ClassLoader system = this.getClass().getClassLoader();
        //URL url = system.getResource(name);
        InputStream stream = this.getClass().getResourceAsStream(name);//getSystemResourceAsStream(name);
                //this.getClass().getResourceAsStream(name);



        if (stream == null){
            System.out.println("null");
        }else {
            System.out.println(stream.toString());
        }

    }
}
