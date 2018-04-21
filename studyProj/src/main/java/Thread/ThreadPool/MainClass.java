package Thread.ThreadPool;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static void main(String[] args) {
        String[] filenames = new String[1];
        ExecutorService pool = Executors.newFixedThreadPool(4);
        filenames[0] = "H:/BaiduNetdiskDownload/嗨翻C.pdf";
        for(String filename: filenames){
            File f= new File(filename);
            if(f.exists()){
                Runnable task = new GZipRunable(f);
                pool.submit(task);
            }
        }
        pool.shutdown();
    }
}
