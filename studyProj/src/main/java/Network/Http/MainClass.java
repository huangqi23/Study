package Network.Http;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws IOException {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        CookieHandler.setDefault(cookieManager);

        URL url = new URL("http://www.baidu.com");
        InputStream i = url.openStream();
        int t;
        byte[] arr = new byte[64];
        while ((t=i.read(arr))!=-1){
            System.out.println(new String(arr));
            Arrays.fill(arr, (byte) 0);
        }
        //获取本地cookie库
        CookieStore cookieStore =  cookieManager.getCookieStore();
        List<HttpCookie> list =  cookieStore.getCookies();

        for(HttpCookie httpCookie : list){
            System.out.println(httpCookie.getName());
            System.out.println(httpCookie.toString());

        }
    }
}
