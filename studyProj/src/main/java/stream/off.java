package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class off {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:/HQ.ini");
        byte[] arr = new byte[64] ;

        int len;
        while ((len = fileInputStream.read(arr, 0, 64)) != -1){

            System.out.println(new String(arr) );
            java.util.Arrays.fill(arr, (byte) 0);
        }

    }
}
