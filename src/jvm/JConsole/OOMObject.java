package jvm.JConsole;

import sun.org.mozilla.javascript.internal.Synchronizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew  on 2016/11/4.
 */
public class OOMObject {
    static class OMObject{
        public byte[]placeholder=new byte[64*1024];

    }
    public static void filHeap(int num)throws InterruptedException{
        List<OMObject>list=new ArrayList<>();
        for (int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OMObject());
        }
        System.gc();
    }
    public static void createBusyThread(){
        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        },"testBusyThread");
        thread.start();
    }

    /**
     * 演示线程死锁
     * @param lock
     */
    public static void createLockThread(final Object lock){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }
    static class SynAddRunalble implements Runnable{
        int a,b;

        public SynAddRunalble(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)throws Exception{
//        filHeap(1000);-Xms100m -Xmx100m -XX:+UseSerialGC

        //测试死循环，线程等待
/*        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));测试死循环，线程等待
        br.readLine();
        createBusyThread();
        br.readLine();
        Object object=new Object();
        createLockThread(object);*/

        //测试死锁
        for (int i=0;i<100;i++){
            new Thread(new SynAddRunalble(1,2)).start();
            new Thread(new SynAddRunalble(1,2)).start();
            Thread.sleep(500);
        }
    }
}

