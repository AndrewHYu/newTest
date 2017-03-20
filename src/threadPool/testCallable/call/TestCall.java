package threadPool.testCallable.call;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Andrew  on 2017/3/20.
 */
public class TestCall {
    public static void main(String[] args) throws Exception {
        CallableTask callableTask = new CallableTask();
        System.out.println(Thread.currentThread().getName());
        FutureTask future = new FutureTask(callableTask);
        new Thread(future).start();
        System.out.println(future.get());
    }
}
