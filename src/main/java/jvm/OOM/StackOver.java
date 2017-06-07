package jvm.OOM;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrew  on 2017/5/8.
 * -Xms3000m -Xmx3000m -Xss1024k
 */
public class StackOver {
    public static void main(String[] args) throws InterruptedException {
        StackOver stackOver = new StackOver();
        stackOver.over(20000);
        TimeUnit.SECONDS.sleep(20);
    }
    public void over(int n){
        if (n==0){
            System.out.println("over");
        }else {
            over(--n);
        }
    }
}
