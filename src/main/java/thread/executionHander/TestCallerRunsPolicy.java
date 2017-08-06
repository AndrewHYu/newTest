package thread.executionHander;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Andrew  on 2017/7/9.
 */
public class TestCallerRunsPolicy {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,4,0l, TimeUnit.SECONDS
                ,new LinkedBlockingQueue<Runnable>(3));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        Thread productor = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0;i <30;i ++){
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Thread pool "+Thread.currentThread().getName());
                            try {
                                TimeUnit.SECONDS.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println();
                        }
                    });
                }
            }
        });

        productor.start();
    }
}
