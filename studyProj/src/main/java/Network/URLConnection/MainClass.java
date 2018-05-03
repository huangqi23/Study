package Network.URLConnection;


import sun.plugin2.jvm.CircularByteBuffer;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) throws IOException {
        MainClass mainClass = new MainClass();
        mainClass.showHeaders();
    }
    public void showHeaders()throws IOException {
        URL url = new URL("http://www.bookbaow.com/book/download.asp?softid=69338&downid=4&id=69338");

        URLConnection c =  url.openConnection();
        c.addRequestProperty("aa","bbb");
        c.connect();
        for (int i=1;;i++){
            String header = c.getHeaderFieldKey(i);
            if (header == null)break;
            System.out.println(header+":"+c.getHeaderField(header));
        }

        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
        while ((tempLine = reader.readLine()) != null) {
            resultBuffer.append(tempLine);
        }
        System.out.println(resultBuffer);
    }

    public void downloadfile() throws IOException{
        URL url = new URL("http://www.bookbaow.com/book/download.asp?softid=69338&downid=4&id=69338");
        URLConnection urlConnection =  url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        InputStream buf = new BufferedInputStream(inputStream);
        int length = urlConnection.getContentLength();
        int c;
        byte[] arr = new byte[length];
        int offset = 0;
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        while (offset<length ){
            int bytesread = in.read(arr, offset, arr.length -offset);
            if(bytesread == -1) break;
            offset += bytesread;

        }
        if(offset!= length){
            System.out.println("read error");
        }
        try (OutputStream fout = new FileOutputStream("C:/a.tmp")){
            fout.write(arr);
            fout.flush();
        }

        System.out.println(urlConnection.getContentType());
        System.out.println(urlConnection.getContentLength());
        System.out.println( urlConnection.getContentEncoding());
    }


}
