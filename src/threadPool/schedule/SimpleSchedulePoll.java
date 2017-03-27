package threadPool.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Andrew  on 2017/3/22.
 */
public class SimpleSchedulePoll {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executor = Executors.newScheduledThreadPool(2);
//        Executors.newCachedThreadPool()
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        ExecutorService executorServiceTwo = Executors.newFixedThreadPool(2);
        List<Future<Integer>> futureList = new ArrayList<>();
        List<ScheduledFuture<Integer>> futureListTwo = new ArrayList<>();
        for (int i=0;i<3;i++){
             ScheduledFuture scheduledFuture= executorService.scheduleWithFixedDelay(new ByRunnable(i), 1,10, TimeUnit.SECONDS);
//            Future<Integer> future = executorServiceTwo.submit(new ByCallable(i));
            Thread.sleep(1000);
            long time = scheduledFuture.getDelay(TimeUnit.SECONDS);
//            System.out.println(time);
            futureListTwo.add(scheduledFuture);
        }
/*        Thread.sleep(5000);
        executorService.shutdownNow();
*//*        for (ScheduledFuture f:
                futureListTwo ){
            f.cancel(true);
        }*//*
        for (ScheduledFuture f:
                futureListTwo ){
            System.out.println("before");
            System.out.println(f.get());
            System.out.println("after");
        }*/
    }

}
