package Network.URL;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Enumeration;

public class MainClass {
    public static void main(String[] args) throws IOException {
        MainClass mainClass = new MainClass();
         /*URL url = new URL("http://www.baidu.com/id/1.html");
        System.out.println(url.getProtocol());
        URL url1 = new URL(url,"index.html");
        System.out.println(url1.toString());

        File file = new File("C:/HQ.ini");
        System.out.println(file.toURL().toString());*/
        mainClass.testGetContent();
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
