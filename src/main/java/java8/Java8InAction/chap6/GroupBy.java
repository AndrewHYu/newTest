package java8.Java8InAction.chap6;

import java8.Java8InAction.chap4.Dish;

import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

/**
 * @author Andrew
 * @date 2017/12/16
 */
public class GroupBy {
    public static void main(String[] args) {
        Map<Dish.Type, Set<CaloricLevel>> map = Dish.menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                        else return CaloricLevel.FAT; },
                        toSet() )));
    }
}
