package Network.URL;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Arrays;
import java.util.Enumeration;

public class MainClass {
    public static void main(String[] args) throws IOException, URISyntaxException {
        MainClass mainClass = new MainClass();
         /*URL url = new URL("http://www.baidu.com/id/1.html");
        System.out.println(url.getProtocol());
        URL url1 = new URL(url,"index.html");
        System.out.println(url1.toString());

        File file = new File("C:/HQ.ini");
        System.out.println(file.toURL().toString());*/
        //mainClass.testGetContent();

        /*URI uri = new URI("http://www.baidu.com");

        if (uri.isOpaque()){ //Opaque：不透明的 ，有层次时返回false，没层次时返回true
            System.out.println("isOpaque");
        }else{
            System.out.println("notOpaque");
        }
        if (uri.isAbsolute()){ //绝对
            System.out.println("isAbsolute");
        }else{
            System.out.println("notAbsolute");
        }*/
        mainClass.testresolve();
    }

    public void testresolve() throws URISyntaxException {
        URI uri = new URI("http://www.baidu.com");
        URI uri1 = new URI("/aa/index");
        System.out.println(uri.resolve(uri1)); //1+0
        System.out.println(uri1.resolve(uri));

        URI uri2 = new URI("http://www.baidu.com/aa/index");
        URI uri3 = new URI("http://www.baidu.com");
        System.out.println(uri2.relativize(uri3));
        System.out.println(uri3.relativize(uri2));// 2-3
        try {
            InputStream inputStream = uri3.toURL().openStream();
            int c;
            byte[] arr = new byte[64];
            while ((c=inputStream.read(arr))!=-1){
                System.out.println(new String(arr));
                Arrays.fill(arr, (byte) 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetContent() throws IOException {
        URL url = new URL("http://www.baidu.com");
        Object o = url.getContent();
        System.out.println(o.getClass().getName());
        InputStream inputStream = (InputStream)o;
        //URLConnection urlConnection = url.openConnection();
        //InputStream inputStream = (InputStream) urlConnection.getContent();
        int c;
        byte[] arr = new byte[64];
        while ((c=inputStream.read(arr))!=-1){
            System.out.println(new String(arr));
            Arrays.fill(arr, (byte) 0);
        }
    }

    public void testOpenStream() throws IOException {
        URL url = new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();
        int c;
        byte[] arr = new byte[64];
        while ((c=inputStream.read(arr))!=-1){
            System.out.println(new String(arr));
            Arrays.fill(arr, (byte) 0);
        }

        //System.out.println(url.getProtocol());
    }

    public void testOpenConnection() throws IOException {
        URL url = new URL("http://www.baidu.com");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        int c;
        byte[] arr = new byte[64];
        while ((c=inputStream.read(arr))!=-1){
            System.out.println(new String(arr));
            Arrays.fill(arr, (byte) 0);
        }

        //System.out.println(url.getProtocol());
    }



}
