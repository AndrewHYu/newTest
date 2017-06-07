package XATest;

/**
 * Created by Andrew  on 2016/9/10.
 */
public class Test {
    public static volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Test test = new Test();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1 )  //保证前面的线程都执行完
            System.out.println(Thread.activeCount());
            Thread.yield();
        System.out.println(test.inc);
    }
}
