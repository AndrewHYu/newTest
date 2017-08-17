package jvm.jvmShotdownHook;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyu
 * @date 2017/8/14
 */
public class TestHook {
    public static void main(String[] args) throws InterruptedException {


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                        break;
                    }
                    System.out.println(1);
                }

            }
        });
        t.start();

//        t.interrupt();
        ShutdownThread shutdownThread = new ShutdownThread(t);
//        shutdownThread.start();

        TimeUnit.SECONDS.sleep(1);
        Runtime.getRuntime().addShutdownHook(shutdownThread);
//        t.interrupt();
        System.exit(0);
        System.out.println("+++++++++++++++++++++++++++++++++++");
    }
    private static class ShutdownThread extends Thread{

        private Thread t ;
         ShutdownThread(Thread t) {
            this.t = t;
        }

        @Override
        public void run() {
            System.out.println("try to interrupt t");
            t.interrupt();
        }
    }
}
