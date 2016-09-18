package problem;

import java.math.BigDecimal;

/**
 * Created by Andrew on 2016/4/15.
 */
public class CountTest {
    private volatile long[]longs=new long[4];

    public static void main(String args[]){
        System.out.println(2.0-1.1);
        System.out.println(new BigDecimal("2.0").subtract(new BigDecimal("1.1")));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(12345+54321);
        System.out.println(0xffffffff);
        byte b=-1;
        System.out.println((int)(char)b);
        System.out.println((int)(char)(b & 0xff));
        System.out.println(Long.MAX_VALUE==0xffffffff);
        System.out.println((int)'c');
        System.out.println((int)(short)'c');

    }
}
