package tomcat.ex02.pyrmont;

import java.io.File;

public class Constants {

  public static final String WEB_ROOT =
          System.getProperty("user.dir") + File.separator  + "webroot";
      //System.getProperty("user.dir") + File.separator + "webroot" +File.separator+(test.class.getPackage().getName()).replaceAll("\\.", "\\\\");
    //System.getProperty("user.dir") + File.separator  + "target" + File.separator  +"classes"+ File.separator+ (test.class.getPackage().getName()).replaceAll("\\.", "\\\\");
}