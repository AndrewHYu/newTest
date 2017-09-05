package jvm.gc;

import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyu
 * @date 2017/8/28
 * -verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40M -XX:+DisableExplicitGC -XX:+PrintCompilation
 */
public class TestDirectByteBuffer {
    Byte[] b = new Byte[1024* 1024];
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe;
        unsafe = (Unsafe)f.get(null);

/*        while (true)
        {
            //大量fullGC，但是不会outOfMemory
            ByteBuffer buffer = ByteBuffer.allocateDirect(10 * 1024 * 1024);
            ((DirectBuffer)buffer).cleaner().clean();

            //outOfMemory
            long pointer = unsafe.allocateMemory(1024 * 1024 * 20);
            unsafe.freeMemory(pointer);
            System.out.println(unsafe.getByte(pointer + 1));
        }*/
        if(true){
            ByteBuffer buffer = ByteBuffer.allocateDirect(10 * 1024 * 1024);
            ByteBuffer buffer2 = ByteBuffer.allocateDirect(20 * 1024 * 1024);
        }
      /*  while (true){
            TestDirectByteBuffer g = new TestDirectByteBuffer();
        }*/
        TimeUnit.SECONDS.sleep(30);
    }

}
