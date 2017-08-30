package jvm.gc;

/**
 * @author huangyu
 * @date 2017/8/28
 */
public class OutClazz {
    public OutClazz() {
        System.out.println(new StaticInnerClazz());
    }

    private static class StaticInnerClazz{

    }

    public static void main(String[] args) {
        OutClazz oc = new OutClazz();
        OutClazz o2c = new OutClazz();
    }
}
