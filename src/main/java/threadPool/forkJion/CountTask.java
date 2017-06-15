package threadPool.forkJion;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Andrew  on 2017/6/13.
 */
public class CountTask extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;

        boolean moreCompute = (end - start) <= THRESHOLD;
        if (moreCompute){
            for (int i = start; i <= end; i++){
                sum +=i;
            }
        }else {
            int middle = (start + end)/2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle,end);
            System.out.println("开始子任务");
            leftTask.fork();
            rightTask.fork();

            System.out.println("等待结果");
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            System.out.println("结束子任务");

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,8);
        Future<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());
    }
}
