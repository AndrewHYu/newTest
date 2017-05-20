package TestAnnotation.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew  on 2017/5/19.
 */
public class Sample2 {
    @Test
    @ExceptionTest(ArithmeticException.class)
    public static void m1(){
        int i = 0;
        i = i / i;
    }
    @Test
    @ExceptionTest(ArithmeticException.class)
    public static void m2(){
        int [] a = new  int[0];
        int i = a[1];
    }
    @Test
    @ExceptionTest(ArithmeticException.class)
    public static void m3(){ }
    @Test
    @ExceptionTest({IndexOutOfBoundsException.class,NullPointerException.class})
    public static void doublyBad(){
        List<String> list = new ArrayList<>();

        list.addAll(5,null);
    }
}
