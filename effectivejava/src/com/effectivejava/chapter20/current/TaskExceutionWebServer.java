package com.effectivejava.chapter20.current;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by maskwang on 2017/9/11 0011.
 */
public class TaskExceutionWebServer {
    private static final int PORT = 8919;
    private static final int NTHREADS=10;
    private static final Executor exec= Executors.newFixedThreadPool(NTHREADS);


    public static void main(String[] args) throws IOException {
        final  ServerSocket server = new ServerSocket(PORT);
        int i=0;
        while (true){
            Runnable task=new Runnable() {
                @Override
                public void run() {
                    handle(server);
                }
            };
            exec.execute(task);
            i++;
        }

    }

    public static void handle(ServerSocket server){
        try {
            Socket socket = server.accept();
            Reader reader = new InputStreamReader(socket.getInputStream());
            char chars[] = new char[1024];
            int len;
            StringBuilder builder = new StringBuilder();
            while ((len=reader.read(chars)) != -1) {
                builder.append(new String(chars, 0, len));
            }
            System.out.println("Receive from client message=: " + builder);
            reader.close();
            //socket.close();
            //server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
