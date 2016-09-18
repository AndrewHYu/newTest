package threadPool;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 * Created by Andrew  on 2016/9/11.
 */
@ThreadSafe
public class TestLock {
    public static void main(String[] args) {
        final TestLock testLock=new TestLock();
        for (int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(new TestLock().getNext());
                }
            }).start();
        }
    }
    @GuardedBy("this")private  int value;
    public synchronized  int getNext(){
        return value++;
    }
}
