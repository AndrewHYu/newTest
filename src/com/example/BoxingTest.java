package com.example;

import java.util.Comparator;

/**
 * Created by Andrew  on 2017/5/24.
 */
public class BoxingTest {
    static Integer i ;
    public static void main(String[] args) {
        Comparator<Integer> naturalOrder = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1);
            }
        };
        System.out.println(naturalOrder.compare(new Integer(42),new Integer(42)));
        System.out.println(naturalOrder.compare(Integer.valueOf(43),Integer.valueOf(43)));
        System.out.println(naturalOrder.compare(Integer.valueOf(133),Integer.valueOf(133)));


        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));


        //@throw NullPointerException,i Integer，二不是int ，初始值为null
        //在一项操作中混合使用基本类型和装箱基本类型时装箱基本类型就会自动拆箱
        //null 对象自动拆箱就会得到 NullPointerException
 /*       if (i ==42){
            System.out.println("Unbelievable");
        }*/
    }
}
