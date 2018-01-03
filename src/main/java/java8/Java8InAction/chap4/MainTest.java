package java8.Java8InAction.chap4;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Andrew
 * @date 2017/12/14
 */
public class MainTest {
    public static void main(String[] args) {
        List<String> names = Dish.menu.stream().
                filter(dish -> {
                    System.out.println("filter "+dish);
                    return dish.getCalories() > 300;
                })
                .sorted(comparing(dish -> {
                    System.out.println("sorted "+dish);
                    return dish.getCalories();
                }))
                .map(dish -> {
                    System.out.println("map "+dish);
                    return dish.getName();
                })
//                .limit(3)
                .distinct()//将map改为calorie测试
                .collect(toList());
        List<String> names2 = Dish.menu.stream().
                filter(dish -> {
                    System.out.println("filter "+dish);
                    return dish.getCalories() > 300;
                })
                .sorted((Dish d1, Dish d2) -> d1.getCalories() < d2.getCalories() ? -1 : d1.getCalories() == d2.getCalories() ? 0 : 1)
                .map(Dish :: getName)
//                .limit(3)
                .distinct()//将map改为calorie测试
                .collect(toList());
        List<Dish> sortDish = Dish.menu.stream()
                .sorted((Dish d1, Dish d2) -> d1.getCalories() < d2.getCalories() ? -1 : d1.getCalories() == d2.getCalories() ? 0 : 1)
                .collect(Collectors.toList());
        long count = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();

        System.out.println(count);

        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLength = words.stream()
                                        .map(String::length).collect(Collectors.toList());

        List<Integer> dishNameLenths = Dish.menu.stream()
                                                        .map(Dish::getName)
                                                        .map(String::length)
                                                        .collect(Collectors.toList());

        List<String> helloWord = Arrays.asList("Hello", "World");
        List<String[]> hello = helloWord.stream().map(word -> word.split(""))
                        .distinct()
                        .collect(Collectors.toList());

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWord = Arrays.stream(arrayOfWords);
        List<Stream<String>> list = streamOfWord.map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());

        Optional<Dish> dish =
                Dish.menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }



}
