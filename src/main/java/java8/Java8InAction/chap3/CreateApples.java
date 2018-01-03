package java8.Java8InAction.chap3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Andrew
 * @date 2017/12/13
 */
public class CreateApples {
    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
// etc...
    }
    public static Fruit giveMeFruit(String fruit, Integer weight){
        return map.get(fruit.toLowerCase())
                .apply(weight);
    }
    public static void main(String[] args) {
        List<Integer> weight = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weight, Apple::new);
    }

    public static List<Apple> map(List<Integer> list, Function<Integer,Apple> f){
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
    }
    interface Fruit{

    }
    static class Apple implements Fruit{
        private int weight ;
        private String color;

        public Apple() {
        }

        public Apple(int weight) {
            this.weight = weight;
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
    }
    static class Orange implements Fruit{
        private int weight ;
        private String color;

        public Orange() {
        }

        public Orange(int weight) {
            this.weight = weight;
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
    }
}
