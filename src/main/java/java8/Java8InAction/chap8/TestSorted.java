package java8.Java8InAction.chap8;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 测试stream的sorted方法，当数据是基本类型且使用comparing时存在自动装箱，应尽可能直接使用comparator
 * @author Andrew
 * @date 2017/12/25
 */
public class TestSorted {
    public static void main(String[] args) {
        long start = 0L, end = 0L;
        //生成随机数
        Stream<Food> foodStream = IntStream.iterate(5,(x) -> new Random(x).nextInt(100)).limit(50).mapToObj(Food::new);

        start = System.nanoTime();
        List<Food>  foods = foodStream.sorted(Comparator.comparing(Food::getCalories)).collect(Collectors.toList());
        end = System.nanoTime();
        System.out.println("first: " + (end - start) / 1_000_000);

        Stream<Food> foodStream2 = IntStream.iterate(5,(x) -> new Random(x).nextInt(100)).limit(50).mapToObj(Food::new);

        start = System.nanoTime();
        List<Food>  foods2 = foodStream2
                .sorted((f1, f2) ->  f1.getCalories() < f2.getCalories() ? -1 : f1.getCalories() == f2.getCalories() ? 0 : 1)
                .collect(Collectors.toList());
        end = System.nanoTime();
        System.out.println("second: " + (end - start) / 1_000_000);

        /*
        *使用更好的方式测试
         */
        List<Food> foodList = IntStream.iterate(4,(x) -> new Random(x).nextInt(1_000))
                .limit(800)
                .mapToObj(Food::new)
                .collect(Collectors.toList());

        //另一种生成随机数的方式,比上面一种更优。上面的方式会重复生成random对象，下面的方式利用闭包只存在一个random对象
        Random r = new Random(5);
        List<Food> foodList2 = IntStream.generate(() -> r.nextInt(1_000))
                .limit(800)
                .mapToObj(Food::new)
                .collect(Collectors.toList());

        start = System.nanoTime();
        foodList2.stream()
                .sorted(Comparator.comparing(Food::getCalories))
                .collect(Collectors.toList());
        end = System.nanoTime();
        System.out.println("third: " + (end - start) / 1_000_000);

        start = System.nanoTime();
        foodList2.stream()
                .sorted((f1, f2) ->  f1.getCalories() < f2.getCalories() ? -1 : f1.getCalories() == f2.getCalories() ? 0 : 1)
                .collect(Collectors.toList());
        end = System.nanoTime();
        System.out.println("fourth: " + (end - start) / 1_000_000);


    }
    static class Food{
        private int calories;

        public Food(int calories) {
            this.calories = calories;
        }

        public int getCalories() {
            return calories;
        }
    }
}
