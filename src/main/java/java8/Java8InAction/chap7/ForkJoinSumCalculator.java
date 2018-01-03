package java8.Java8InAction.chap7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author Andrew
 * @date 2017/12/22
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
    public static final long THRESHOLD = 10_000;

    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD)
            return computeSequentially();
        int middle = start + length/2;
        ForkJoinSumCalculator left = new ForkJoinSumCalculator(numbers, start, middle);
        left.fork();
        ForkJoinSumCalculator right = new ForkJoinSumCalculator(numbers, middle, end);
        Long rightResult = right.compute();
        Long leftResult = left.join();

        return rightResult + leftResult;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 100_000_000).toArray();
        long start = System.nanoTime();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        long result = FORK_JOIN_POOL.invoke(task);
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Result: "+result+" and time "+ duration);
    }
    private long computeSequentially(){
        long sum = 0;
        for (int i = start; i < end; i++){
            sum += numbers[i];
        }
        return sum;
    }
}
