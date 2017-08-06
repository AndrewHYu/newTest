package jvm.softRefence;

import jnr.ffi.annotations.In;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyu
 * @date 2017/7/25
 */
public class TestSoftRefenceGC {
    private int index;
    private byte[] bytes = new byte[1024*1024];

    public static final ConcurrentHashMap<Integer,SoftReference<TestSoftRefenceGC>> cache = new ConcurrentHashMap<>();

    public TestSoftRefenceGC(int index) {
        this.index = index;
    }

    static List<Object> objects = new ArrayList<>(1000);
    static ReferenceQueue<TestSoftRefenceGC>  referenceQueue = new ReferenceQueue();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0 ; i < 1000; i++){
            TestSoftRefenceGC o = new TestSoftRefenceGC(i);
            SoftReference<TestSoftRefenceGC> objectSoftReference = new SoftReference<>(o,referenceQueue);

            cache.put(i,objectSoftReference);

        }
            TimeUnit.SECONDS.sleep(5);

            for (Reference tt = referenceQueue.poll();tt != null ;){

            }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(index);
    }
}
