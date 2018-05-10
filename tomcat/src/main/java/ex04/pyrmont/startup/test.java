package ex04.pyrmont.startup;

import java.util.ResourceBundle;

public class test {
    public static void main(String[] args) {
        String bundleName = "org.apache.catalina.connector.http" + ".LocalStrings";
        ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
        System.out.println(bundle.getString("httpConnector.alreadyInitialized"));
    }
}
