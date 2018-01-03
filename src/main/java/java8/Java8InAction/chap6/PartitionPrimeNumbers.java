package java8.Java8InAction.chap6;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.*;

/**
 * @author Andrew
 * @date 2017/12/21
 */
public class PartitionPrimeNumbers {
    public static final int TEST_NUMBER = 1_000_000;
    public static void main(String[] args) {
        long fastest = Long.MAX_VALUE;
        for(int i = 0;i < 5; i++){//多次测试取最优
            long start = System.nanoTime();
            Map<Boolean,List<Integer>> result = partitionPrimes(TEST_NUMBER);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if(duration < fastest)
                fastest = duration;
//            System.out.println(result);
        }
        System.out.println(" New method fastest execution done in " + fastest + " msecs");

        long fastest2 = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++){
            long start = System.nanoTime();
            Map<Boolean,List<Integer>> result = IntStream.rangeClosed(2,TEST_NUMBER).boxed().collect(Collectors.partitioningBy(j -> isPrimeOld(j)));
            long duration = (System.nanoTime() - start) / 1_000_000;
            if(duration < fastest2)
                fastest2 = duration;
//            System.out.println(result);
        }
        System.out.println(" Old method fastest execution done in " + fastest2 + " msecs");
    }
    public static Map<Boolean,List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2,n).boxed().collect(new PrimeNumbersCollector());
    }
    public static boolean isPrimeOld( int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2,candidateRoot).boxed().noneMatch(i -> candidate % i == 0);

    }
    public static boolean isPrime(List<Integer>primes, int candidate){
//        return primes.stream().noneMatch(i -> candidate % i == 0);
        double candidateRoot =  Math.sqrt((double) candidate);
        return takeWhile(primes,i -> i <= candidateRoot).stream().noneMatch(i -> candidate % i == 0);
    }
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p){
        int i = 0;
        for (A item : list) {
            if (!p.test(item))
                return list.subList(0,i);
            i++;
        }
        return list;
    }
    public static class PrimeNumbersCollector implements Collector<Integer,Map<Boolean,List<Integer>>, Map<Boolean,List<Integer>>>{

        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            return () -> new HashMap<Boolean, List<Integer>>(){{
                put(true,new ArrayList<Integer>());
                put(false,new ArrayList<Integer>());
            }};
        }

        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            return (Map<Boolean,List<Integer>> acc, Integer candidate) -> {
                acc.get(isPrime(acc.get(true),candidate)).add(candidate);
            };
        }

        // TODO: 2017/12/21 事实上本算法不支持并行，只是为了创建一个完整的收集器才写的
        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            return (Map<Boolean,List<Integer>> map1, Map<Boolean,List<Integer>> map2) -> {
                map1.get(true).addAll(map2.get(true));
                map2.get(false).addAll(map2.get(false));
                return map1;
            };
        }

        @Override
        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
        }
    }
}
