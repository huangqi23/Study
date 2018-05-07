package tomcat.ex02.pyrmont;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class test {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("java.home : "+System.getProperty("java.home"));

        System.out.println("java.class.version : "+System.getProperty("java.class.version"));

        System.out.println("java.class.path : "+System.getProperty("java.class.path"));

        System.out.println("java.library.path : "+System.getProperty("java.library.path"));

        System.out.println("java.io.tmpdir : "+System.getProperty("java.io.tmpdir"));

        System.out.println("java.compiler : "+System.getProperty("java.compiler"));

        System.out.println("java.ext.dirs : "+System.getProperty("java.ext.dirs"));

        System.out.println("user.name : "+System.getProperty("user.name"));

        System.out.println("user.home : "+System.getProperty("user.home"));

        System.out.println("user.dir : "+System.getProperty("user.dir")+ File.separator  + "webroot");

        System.out.println("===================");

        System.out.println("package: "+test.class.getPackage().getName());

        System.out.println("package: "+test.class.getPackage().toString());

        System.out.println("=========================");

        String packName = test.class.getPackage().getName();

                /*URL packurl = new URL(packName);

                System.out.println(packurl.getPath());*/

        URI packuri = new URI(packName);

        System.out.println(packuri.getPath());

        //System.out.println(packuri.toURL().getPath());

        System.out.println(packName.replaceAll("//.", "/"));

        System.out.println(System.getProperty("user.dir")+"/"+(test.class.getPackage().getName()).replaceAll("//.", "/")+"/");
        System.out.println(System.getProperty("user.dir") + File.separator  + "target" + File.separator  +"classes"+ File.separator  + new String(test.class.getPackage().getName()).replaceAll("\\.", "\\\\"));

    }
}
