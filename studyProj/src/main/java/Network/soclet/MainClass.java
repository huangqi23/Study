package Network.soclet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClass {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",30000);
        socket.setSoTimeout(1000);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.write("sb");

        /*InputStream inputStream = socket.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, "ASCII");
        StringBuilder stringBuilder = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1){
            stringBuilder.append((char)c);
        }
        System.out.println(stringBuilder);*/
    }
}
