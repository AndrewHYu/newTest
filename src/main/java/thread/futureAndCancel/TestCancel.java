package thread.futureAndCancel;

import java.util.concurrent.*;

/**
 * Created by Andrew  on 2017/7/8.
 */
public class TestCancel {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
 /*       ExecutorService exs = Executors.newFixedThreadPool(1);
        Future task = exs.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("begin");
                while (true){
//                    Thread.sleep(5000);
                    System.out.println("sleep");
                    return 1;
                }
            }
        });

        boolean isCanceled = task.cancel(true);
        task.get();
        System.out.println(isCanceled);*/


        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("begin");
                while (true){
                    TimeUnit.SECONDS.sleep(3); // 是否休眠结果不同
                }
            }
        });

        Thread thread = new Thread(futureTask);
        thread.start();

        TimeUnit.SECONDS.sleep(2);
        futureTask.cancel(false); //true/false 结果不同美国
    }
}
