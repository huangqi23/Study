package Thread.ThreadPool;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class GZipRunable implements Runnable{

    private File input;
    public GZipRunable(File input1) {
        this.input = input1;
    }

    @Override
    public void run() {
        File output = new File(input.getParent(), input.getName()+".gz");
        //写在try里，运行完自动关闭
        //Buffered缓冲流，有益无害
        try(InputStream inputStream = new BufferedInputStream(new FileInputStream(input));
            OutputStream outputStream = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)))
        ) {
            int b;
            while ((b= inputStream.read())!= -1) outputStream.write(b);
            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
