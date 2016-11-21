package jvm.gc;

/**
 * Created by Andrew  on 2016/11/3.
 */
public class BIgObject {
    private static final int _1MB=1024*1024;

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
    public static void testPretenureSizeThreshold(){
        byte[]allocation;
        allocation=new byte[4*_1MB];
    }
}
