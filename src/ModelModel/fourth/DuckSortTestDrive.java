package ModelModel.fourth;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Andrew  on 2016/10/11.
 */
public class DuckSortTestDrive {
    public static void main(String[] args) {
        String[]strings={"www","eee"};
        Object[] a = new Object[] {"1", "2"};
        String[] array = (String[])a;
        Duck[]ducks={
                new Duck("Daffy",8),
                new Duck("Dewey",2),
                new Duck("Howard",7),
                new Duck("Louie",2),
                new Duck("Donald",10),
                new Duck("Huey",2)
        };
        System.out.println("Before Sort:");

        display(ducks);

        Arrays.sort(ducks);

        System.out.println("\nAfter sorting:");
        display(ducks);

    }
    public static void display(Duck[]ducks){
        for (Duck duck:
             ducks) {
            System.out.println(duck);
        }
    }
}
