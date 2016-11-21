package jvm.outMemory.stakeOut;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by Andrew  on 2016/10/29.
 */
public class DirectMemoryOOM {
    private static final int _1MB=1024*1024;
    public static void main(String[] args) {
        Field unsafeField= Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        try {
            Unsafe unsafe=(Unsafe)unsafeField.get(null);
            while (true){
                System.out.println("get");
            unsafe.allocateMemory(_1MB);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
