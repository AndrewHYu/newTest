package threadPool.schedule;

import java.util.concurrent.Callable;

/**
 * Created by Andrew  on 2017/3/22.
 */
public class ByCallable implements Callable<Integer> {
    private int id;

    public ByCallable(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("callable Thread"+Thread.currentThread().getName());
        return id;
    }
}
