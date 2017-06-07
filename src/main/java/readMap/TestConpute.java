package readMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Andrew  on 2017/2/17.
 */
public class TestConpute {
    public static void main(String[] args) {
        int ssize=1;
        ConcurrentHashMap map=new ConcurrentHashMap();
        for (int i=1;i<16;i++) {
            ssize <<= 1;
            System.out.println(ssize);
        }
        ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
        Lock readLock=reentrantReadWriteLock.readLock();
        Lock writeLock=reentrantReadWriteLock.writeLock();
        writeLock.lock();
        System.out.println("get write Lock");
        readLock.lock();
        System.out.println("get read lock");
        readLock.unlock();
        writeLock.unlock();
        System.out.println("get read lock");

    }
}
