package stateModel;

import java.util.Random;

/**
 * Created by Andrew  on 2016/10/14.
 */
public class TestRandom {
    public static void main(String[] args) {
        Random random=new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(4));
        System.out.println(random.nextDouble());
    }
}
