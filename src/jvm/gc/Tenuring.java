package jvm.gc;

/**
 * Created by Andrew  on 2016/11/3.
 */
public class Tenuring {
    private static final int _1MB=1024*1024;

    public static void main(String[] args) {
        testTenuringThreshold();
    }
    public static void testTenuringThreshold(){
        byte[] allocation1,allocation2,allocation3;
        allocation1=new byte[_1MB/4];
        allocation2=new byte[_1MB*4];
        allocation3=new byte[_1MB*4];
        allocation3=null;
        allocation1=new byte[_1MB*4];
    }

}
