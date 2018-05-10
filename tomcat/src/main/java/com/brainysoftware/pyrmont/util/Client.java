package com.brainysoftware.pyrmont.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            OutputStream os = socket.getOutputStream();
            boolean autoflush = true;
            PrintWriter out = new PrintWriter( socket.getOutputStream(), autoflush);
            String message = "GET /servlet/ModernServlet HTTP/1.1";
            out.println(message);
            out.println("Host: localhost:8080");
            //out.println("Expect: 100-continue");
            out.println("Connection: Close");

            out.println();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( socket.getInputStream() ) );
            boolean loop = true;
            StringBuffer sb = new StringBuffer(80960);
            while (loop) {
                if ( in.ready() ) {
                    int i=0;
                    while (i!=-1) {
                        i = in.read();
                        sb.append((char) i);

                    }
                    loop = false;
                }
                //Thread.currentThread().sleep(50);
            }

            System.out.println(sb.toString());
            socket.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
