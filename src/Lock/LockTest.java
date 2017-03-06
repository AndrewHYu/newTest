package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Andrew  on 2017/2/18.
 */
public class LockTest {
    private static Lock lock=new ReentrantLock();
    private static Condition condition=lock.newCondition();
    private static Condition condition2=lock.newCondition();
    public static void main(String[] args) {
        for (int i=0;i<1;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getLock();
                }
            }).start();

        }
        for (int i=0;i<1;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getLock2();
                }
            }).start();
        }
    }
    public static void getLock(){
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get lock");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        condition2.signal();
        lock.unlock();
        System.out.println("unlock");
    }
    public static void getLock2(){
        lock.lock();
        try {condition.notify();
            condition2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get lock2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        condition.signal();
        System.out.println("unlock2");
        lock.unlock();
    }
}
