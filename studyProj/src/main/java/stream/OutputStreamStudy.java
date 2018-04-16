package stream;

import sun.net.TelnetOutputStream;

import java.io.*;

public class OutputStreamStudy {
    public static void main(String[] args) throws IOException {

        String content = "abvasdfasdfa";
        byte[] contentInBytes = content.getBytes();


        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:/1.txt");
            generatebytes(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] msg = new byte[200];
        int i,y = 0;
        /*try(FileInputStream fileInputStream = new FileInputStream("C:/1.txt")){
            *//*while ((i=fileInputStream.read())!=-1){
                msg[y] = (byte)i;
                y++;
            }*//*
            fileInputStream.read(msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("C:/1.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            while ((i=bufferedInputStream.read())!=-1){
                msg[y] = (byte)i;
                y++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(msg);

        PrintStream printStream = new PrintStream( "C:/1.txt"  );
        printStream.println("1111");


    }

    public static void  generatebytes(OutputStream outputStream) throws IOException {
        byte[] line = new byte[62];

        int y=0;
        for(int i=33; i<94; i++){
            line[y] =  (byte)i;
            y++;
        }
        line[61] = 1;
        outputStream.write(line);

    }

    public static void  generatebytes2(OutputStream outputStream) throws IOException {
        byte[] line = new byte[62];

        int y=0;
        for(int i=33; i<94; i++){
            outputStream.write(i);
        }
        outputStream.write(2);

    }
}


