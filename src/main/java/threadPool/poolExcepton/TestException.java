package threadPool.poolExcepton;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Andrew  on 2017/7/9.
 */
public class TestException {
    public static void main(String[] args) {
        ExecutorService exs = Executors.newFixedThreadPool(2);
        /**
         * 只有通过execute提交的任务，才能将它抛出的异常交给未捕获异常处理器，
         * 而通过submit提交的任务，无论是抛出未检查异常还是已检查异常都被认为是任务返回状态的一部分，
         * 这个异常将被Future.get封装在ExecuteException中重新抛出
         */
        exs.execute(new Runnable() {
            @Override
            public void run() {
                    throw new RuntimeException("have a exception"); //比较RuntimeException 和Exception 区别
            }
        });
    }
}
