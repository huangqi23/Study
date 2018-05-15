package ex07.pyrmont.startup;

import org.apache.catalina.logger.FileLogger;
import org.apache.catalina.logger.SystemErrLogger;
import org.apache.catalina.logger.SystemOutLogger;

public class Test {
    public static void main(String[] args) {
        testSystemout();
        testErrLog();
    }

    public static void testSystemout(){
        SystemOutLogger logger = new SystemOutLogger();
        logger.log("sb");
    }

    public static  void testFileLogger(){
        System.setProperty("catalina.base", System.getProperty("user.dir"));
        FileLogger logger = new FileLogger();
        logger.setPrefix("FileLog_"); //前缀
        logger.setSuffix(".txt"); //后缀
        logger.setTimestamp(true); //增加时间戳
        logger.setDirectory("webroot");
        logger.log("sb");
    }
    //和SystemOutLogger的差别就是字体颜色？
    public static  void testErrLog(){
        SystemErrLogger logger = new SystemErrLogger();
        logger.log("sb");
    }

}
