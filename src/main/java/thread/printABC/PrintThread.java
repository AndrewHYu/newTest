package thread.printABC;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Andrew  on 2017/3/22.
 */
public class PrintThread implements Runnable{
    private String symbol;
    private Condition conditionA =null;
    private int go = 0;
    private ReentrantLock lock =null;
    //使用原子类，本例中并没有多大意义
    private static AtomicInteger i=new AtomicInteger(0);

    public PrintThread(String symbol, Condition conditionA,int go,ReentrantLock lock) {
        this.symbol = symbol;
        this.lock = lock;
        this.conditionA = conditionA;
        this.go = go;
    }
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                while (i.get() % 3 != go) {
                    conditionA.await();
                }

            } catch (InterruptedException e) {
                        e.printStackTrace();
            }
            //防止过多输出
            if (i.get()==10)break;
            System.out.println("result "+symbol);
            i.getAndIncrement();
//            System.out.println(i.get());
            //可以试试signalAll或signal区别，比较时建议去掉前面的break
            conditionA.signalAll();
            lock.unlock();

        }
    }
}
