package java8.Java8InAction.chap5;

import java.util.Arrays;
import java.util.List;

/**
 * @author Andrew
 * @date 2017/12/14
 */
public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        int sum = numbers.stream().reduce(2, (a, b) -> {
            System.out.println(a);
            return a + b;
        });
        System.out.println(sum);
    }
}
