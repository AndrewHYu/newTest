package thread.testCallable.call;

import java.util.concurrent.Callable;

/**
 * Created by Andrew  on 2017/3/20.
 */
public class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println("CALL cal");
        return 3;
    }
}
