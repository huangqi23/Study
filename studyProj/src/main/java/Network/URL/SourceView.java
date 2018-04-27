package Network.URL;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class SourceView {
    public static void main(String[] args) throws IOException {
        new NetClass().frameshow();
        Authenticator.setDefault(new NetClass());
        URL url = new URL("http://i.baidu.com/center");
        InputStream i = url.openStream();
        int t;
        byte[] arr = new byte[64];
        while ((t=i.read(arr))!=-1){
            System.out.println(new String(arr));
            Arrays.fill(arr, (byte) 0);
        }
    }
}
