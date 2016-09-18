package XATest;

import sun.org.mozilla.javascript.internal.Synchronizer;

/**
 * Created by Andrew  on 2016/8/29.
 */
public class Store {
     public static void main(String[]args){
         Object monitorOne=new Count();
         for (int i=0;i<5;i++){
             new Thread(new In(monitorOne)).start();
             if (i==4){
                 break;
             }
             new Thread(new Out(monitorOne)).start();
         }
     }

}
class Out implements Runnable{

    Object monitor;
    public Out(Object monitor){
        this.monitor=monitor;
    }
    @Override
    public void run() {
            while (true) {
        synchronized (monitor) {
                if (Count.count <= 0) {
                    try {
                        monitor.wait();
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
            if (Count.count <= 0) {
                    monitor.notify();
            }
//            monitor.notify();

//            total--;
//                System.out.println(Thread.currentThread().getName() + "取出一个" + "  仓库剩余：" + total);
            }
        }
    }
}
class In implements Runnable{

    Object monitor;
    public In(Object monitor){
        this.monitor=monitor;
    }
    @Override
    public void run() {
            while (true) {
                 synchronized (monitor) {
                    if (Count.count >= 20)
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    //            total++;
    //                System.out.println(Thread.currentThread().getName() + "存入一个" + "  仓库剩余：" + total);
                    Count.addCount();
                     if (Count.count >= 20) {
                         monitor.notify();
                     }
//                     monitor.notify();
                }
        }
    }
}
class Count {
    static int count =0;
    public  static  void addCount(){
        count++;
        System.out.println(Thread.currentThread().getName() + "存入一个" + "  仓库剩余：" + count);

    }
    public  static  void cutCount(){
        count--;
        System.out.println(Thread.currentThread().getName() + "取出一个" + "  仓库剩余：" + count);
    }
}
