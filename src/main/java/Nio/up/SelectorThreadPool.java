package Nio.up;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Andrew  on 2017/3/2.
 */
public class SelectorThreadPool {
    private static Executor executor= Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws IOException {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket8080 serverSocket8080=new ServerSocket8080(8080);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket8080 serverSocket8080=new ServerSocket8080(8099);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        SelectorTool.getSelectorTool().read();
    }
}
