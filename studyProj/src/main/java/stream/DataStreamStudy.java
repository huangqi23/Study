package stream;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataStreamStudy {
    public static void main(String[] args) {
        /*try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("C:/1.txt"));
            dataOutputStream.writeBytes("asdfasdfa");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*ry {
            Writer writer = new OutputStreamWriter(new FileOutputStream("C:/1.txt"), "UTF-8");
            writer.write("aaa");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Mythread mythread = new Mythread();
        mythread.start();
        Mythread mythread1 = new Mythread();
        mythread1.start();


    }
}

class  Mythread extends Thread {
    @Override
    public void run() {

        /*try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            DigestInputStream digestInputStream = new DigestInputStream(new FileInputStream("C:/1.txt"), messageDigest);
            while (digestInputStream.read()!=-1)
                digestInputStream.close();
            byte[] digest  = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder("C:/1.txt");
            stringBuilder.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(stringBuilder);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        for(int i=0;i<10000;i++){
            System.out.println(i);

        }



    }
}