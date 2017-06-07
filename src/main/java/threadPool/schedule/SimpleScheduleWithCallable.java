package threadPool.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Andrew  on 2017/4/9.
 */
public class SimpleScheduleWithCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        List<ScheduledFuture<Integer>> futureList = new ArrayList<>();
        for (int i=0;i<3;i++){
            ScheduledFuture future = scheduledExecutorService.scheduleWithFixedDelay(new FutureTask(new ByCallable(i)), 1,3, TimeUnit.SECONDS);
/*            future.cancel(true);
            System.out.println(future.get());*/
            futureList.add(future);
        }
        for (ScheduledFuture s:
            futureList ) {
            System.out.println(s.get());
        }


    }
}
