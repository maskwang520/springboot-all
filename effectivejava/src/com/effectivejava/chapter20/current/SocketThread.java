package com.effectivejava.chapter20.current;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by maskwang on 2017/9/11 0011.
 */
public class SocketThread {

    private static final int NTHREADS = 3;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String args[]) throws IOException, InterruptedException {
        String host = "127.0.0.1";
        int port = 8919;
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket client = new Socket(host, port);
                        Writer writer = new OutputStreamWriter(client.getOutputStream());
                        writer.write("Hello From Client");
                        writer.flush();
                        writer.close();
                        client.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }

                }
            };
            exec.execute(runnable);
        }
        Thread.sleep(10000);
    }



}
