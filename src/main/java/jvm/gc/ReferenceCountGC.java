package jvm.gc;

/**
 * Created by Andrew  on 2016/10/29.
 */
public class ReferenceCountGC {
    public  Object instence=null;
    private static final int _1MB=1024*1024;
    private  byte[]bigSize=new byte[2*_1MB];

    public static void main(String[] args) {
        ReferenceCountGC objA=new ReferenceCountGC();
        ReferenceCountGC objB=new ReferenceCountGC();
        objA.instence=objB;
        objB.instence=objA;

        objA=null;
        objB=null;

        System.gc();
    }
}
