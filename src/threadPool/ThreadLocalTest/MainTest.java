package threadPool.ThreadLocalTest;

import java.lang.reflect.Field;

/**
 * Created by Andrew  on 2017/4/9.
 */
public class MainTest {
    private static ThreadLocal<Integer> threadLocalF = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 3;
        }
    };
    private static ThreadLocal<Integer> threadLocalT = new ThreadLocal();
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(threadLocalF.get());
        threadLocalF.set(5);
        System.out.println(threadLocalF.get());
        threadLocalT.set(7);
        System.out.println(threadLocalT.get());


        //使用反射查看ThreadLocalMap 大小。 thread(Thread)->threadLocals(ThreadLocal.ThreadLocalMap)->size
        Thread currentThread = Thread.currentThread();
        Field objectField = currentThread.getClass().getDeclaredField("threadLocals");
        objectField.setAccessible(true);
        Object object  = objectField.get(currentThread);
        Field mapSizeField = object.getClass().getDeclaredField("size");
        mapSizeField.setAccessible(true);
        System.out.println("the size "+mapSizeField.get(object));

        threadLocalT.remove();
        System.out.println("the size "+mapSizeField.get(object));

    }
}
