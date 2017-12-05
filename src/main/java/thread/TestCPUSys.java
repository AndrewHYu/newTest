
package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Andrew
 * @date 2017/12/4
 */
public class TestCPUSys {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        new Thread1(latch).start();
        new Thread1(latch).start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread1.getI());
    }
    static class Thread1 extends Thread{
        private static volatile AtomicBoolean f = new AtomicBoolean(true);
        private static volatile AtomicBoolean f2 = new AtomicBoolean(true);
        private static int i = 0;
        private CountDownLatch countDownLatch ;
        public static int getI() {
            return i;
        }

        public Thread1(CountDownLatch latch) {
            this.countDownLatch = latch;
        }

        @Override
        public void run() {
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 100; j++){
                int temp = i;
                if (f.compareAndSet(true,false))
                    try {
                        System.out.println(temp);
                        TimeUnit.SECONDS.sleep(1);
//                        System.out.println(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                if (j == 99 && f2.compareAndSet(true,false))
                    try {
                        System.out.println("two "+temp);
                        TimeUnit.SECONDS.sleep(1);
//                        System.out.println("two "+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                i = temp +1;
            }
        }
    }
}
