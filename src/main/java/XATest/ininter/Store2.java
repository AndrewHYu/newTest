package XATest.ininter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Andrew  on 2017/2/19.
 */
public class Store2 {
    private static Lock lock = new ReentrantLock(true);
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new In2(lock,condition1,condition2)).start();
            if (i == 4) {
                break;
            }
            new Thread(new Out2(lock,condition1,condition2)).start();
        }
    }

}

class Out2 implements Runnable {

    Lock monitor;
    Condition condition;
    Condition condition2;

    public Out2(Lock monitor, Condition condition, Condition condition2) {
        this.monitor = monitor;
        this.condition = condition;
        this.condition2 = condition2;
    }

    @Override
    public void run() {
        while (true) {
            monitor.lock();
            for (; Count.count <= 0; ) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Count.cutCount();
            condition2.signal();
            monitor.unlock();
        }
    }

}

class In2 implements Runnable {

    Lock monitor;
    Condition condition;
    Condition condition2;

    public In2(Lock monitor, Condition condition, Condition condition2) {
        this.monitor = monitor;
        this.condition = condition;
        this.condition2 = condition2;
    }

    @Override
    public void run() {
        while (true) {
            monitor.lock();
            for (; Count.count >= 20; ) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Count.addCount();
            condition.signal();
            monitor.unlock();
        }
    }

}

class Count {
    static int count = 0;

    public static void addCount() {
        count++;
        System.out.println(Thread.currentThread().getName() + "存入一个" + "  仓库剩余：" + count);

    }

    public static void cutCount() {
        count--;
        System.out.println(Thread.currentThread().getName() + "取出一个" + "  仓库剩余：" + count);
    }
}
