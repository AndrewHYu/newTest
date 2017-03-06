package XATest;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Andrew  on 2017/2/10.
 */
public class ArrayCastTest {
    public static void main(String[] args) {
        Object[] str=new Object[] {"1", "2"};
        String[] array2= (String[])new Object[3];
        String[] array = Arrays.asList(str).toArray(new String[0]);
        System.out.println(array[1]);
    }
}
