package threadPool.futureAndInterrupt;


import jdk8demo.interfaces.E;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Andrew  on 2017/6/15.
 */
public class TestFuture {

    public static void main(String[] args) {
        FutureTask future = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                if (1==1){
                    System.out.println(Thread.currentThread().getName());
                    throw new InterruptedException("interrupted");
                }
                System.out.println("After Interrupted");
/*                while (true){
                    if (new Random().nextInt(20)==2){
                        System.out.println("线程休眠");
                        Thread.sleep(1000);
                    }
                }*/
                return null;
            }
        });
        try {
            Thread thread = new Thread(future);
            thread.start();
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("取消任务");
                    future.cancel(true);
                }
            }).start();*/
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable throwable = e.getCause();
            if (throwable instanceof InterruptedException){
                System.out.println("call thread interrupted");
                Thread.currentThread().interrupted();
            }
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("sssss");
        }
        System.out.println("After main thread interrupted");
    }

}
