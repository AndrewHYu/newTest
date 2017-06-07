package Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Andrew  on 2017/3/20.
 */
public class TestReadAndWriteLock {
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writeLock.lock();
                System.out.println("get write lock............................");
//                System.exit(0);
                writeLock.unlock();
            }
        });

//        thread1.start();
        thread2.start();
        while (true) {
             new Thread(new Runnable() {
                @Override
                public void run() {
                    readLock.lock();
                    System.out.println("get read lock");
                    try {
                        Thread.sleep(1000);
//                        System.out.println("yanchijieshu");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        readLock.unlock();
                    }
                }
            }).start();
        }



    }

}
