package java8.Java8InAction.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Andrew
 * @date 2017/12/4
 */
public class FilteringApple {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                            new Apple(155, "green"),
                                            new Apple(120, "red"));
        List<Apple> greenApples = filterApples(inventory,FilteringApple::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory, Apple::isHeavyApple);
        System.out.println(heavyApples);

        List<Apple> greenApples2 = filterApples(inventory,(Apple a)  -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        List<Apple> heavyApples3 = inventory.stream().filter((Apple a) -> a.getWeight() > 150)
                    .collect(Collectors.toList());
        System.out.println(heavyApples3);
        //并行方式
        List<Apple> heavyApple = inventory.parallelStream().filter((Apple a)-> a.getWeight() > 150)
                                                            .collect(Collectors.toList());

    }
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }


    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple a :inventory) {
            if (predicate.test(a))
                result.add(a);
        }
        return result;
    }
    public static class Apple{
        private int weight ;
        private String color;

        public Apple() {
        }

        public Apple(int weight) {
            this.weight = weight;
        }

        //将这个方法放到这个类只是为了测试，并非好的编程风格
        public static boolean isHeavyApple(Apple apple) {
            return apple.getWeight() > 150;
        }

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
