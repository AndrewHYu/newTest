package java8.Java8InAction.chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Andrew
 * @date 2017/12/15
 */
public class PuttingIntoPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2012)
               /* .sorted((t, t2) -> {
                    System.out.println(t+" and "+t2);
                    return t.getValue() > t.getValue()? 1 :(t.getValue() == t.getValue())? 0 : -1;
                })*/
                .sorted(Comparator.comparing(t -> t.getValue()))
                .collect(Collectors.toList());

        List<String> cities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        List<Trader> traders = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(t -> t.getTrader().getName()))
                .map(Transaction::getTrader)
                .collect(Collectors.toList());

        List<String> traderStr = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        boolean milanBased = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        long count = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0,(a, b) -> (a + b));
        System.out.println(count);

        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.comparing(t -> t));
        System.out.println(max.get());

        //第二种方案
        Optional<Integer> highestValue =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max);


        Optional<Integer> min = transactions.stream()
                .map(Transaction::getValue)
                .min(Comparator.comparing(t -> t));
        System.out.println(max.get());

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
                                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        //无限流
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        //斐波那契元组序列
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

    }
}
