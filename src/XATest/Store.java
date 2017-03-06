package XATest;


import java.io.Serializable;

/**
 * Created by Andrew  on 2016/8/29.
 */
public class Store {
    public static void main(String[] args) {
        Object monitorOne = new Count();
        for (int i = 0; i < 5; i++) {
            new Thread(new In(monitorOne)).start();
            if (i == 4) {
                break;
            }
            new Thread(new Out(monitorOne)).start();
        }
    }

}

class Out implements Runnable {

    Object monitor;

    public Out(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
/*            synchronized (monitor) {
                for (;Count.count <= 0; ) {
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
                monitor.notifyAll();
            }*/
            Count.cutCount();
        }
    }
}

class In implements Runnable {

    Object monitor;

    public In(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
          /*  synchronized (monitor) {
                for (; Count.count >= 20; ) {
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

                Count.addCount();
                monitor.notifyAll();
            }*/
            Count.addCount();
        }
    }
}

class Count implements Serializable{
    private static final long serialVersionUID = 4290975174368803575L;
    static int count = 0;

    public synchronized static  void addCount() {
        while (count>=20){
            try {
                Count.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //等待方便查看
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "存入一个" + "  仓库剩余：" + count);
        Count.class.notify();
    }

    public synchronized static void cutCount() {
        while (count<=0){
            try {
                Count.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //等待方便查看
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "取出一个" + "  仓库剩余：" + count);
        Count.class.notify();
    }
}
