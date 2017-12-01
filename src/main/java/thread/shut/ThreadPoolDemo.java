package thread.shut;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyu
 * @date 2017/9/24
 */
public class ThreadPoolDemo implements Shutdown{
    /**
     * 两种方式实现，线程数都是CPU个数；
     *
     */
//    private ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ExecutorService ex = Executors.newWorkStealingPool();


    private ShutDownThread shutDownThread = ShutDownThread.getDefaultThread();
    //不太优雅
    @PostConstruct
    public void init(){
        shutDownThread.register(this);
    }

    /**
     * 有特殊需求的任务
     */
    private class Worker implements Runnable{
        Runnable commend;

        Worker(Runnable commend) {
            this.commend = commend;
        }

        @Override
        public void run() {
            // TODO: 2017/9/24 执行具体任务，比如发邮件;还可在前后做一些操作。
            commend.run();
        }
    }

    /**
     * 两种方式，看具体场景
     * @param runnable
     */
    public void add(Runnable runnable){
        //1
        ex.execute(new Worker(runnable));
        //2
//        ex.execute(runnable);
    }

    /**
     * 默认关闭策略
     * @return
     */
    public boolean close() {
        try {
            return close(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return false;
        }
    }

    public boolean close(long timeout, TimeUnit unit ) throws InterruptedException {
        ex.shutdown();
        return ex.awaitTermination(timeout, unit);
    }



}

//暂时包级私有，如有拓展再修改
class ShutDownThread extends Thread{
    private static ShutDownThread shutDownThread = new ShutDownThread();
    private boolean hooked = false;
    private List<Shutdown> shutdownList = new ArrayList<>();

    private ShutDownThread() {
    }

    //从jetty中学到的
    private void create() {
        if (!hooked) {
            Runtime.getRuntime().addShutdownHook(this);
            this.hooked = true;
        }
    }

    @Override
    public void run() {
        for (Shutdown t : shutdownList) {
            // TODO: 2017/9/24 判断返回值打印日志
            t.close();
        }
    }
    public boolean register(Shutdown t) {
        create();
        return shutdownList.add(t);
    }

    public static ShutDownThread getDefaultThread(){
        return shutDownThread;
    }
}
interface Shutdown {
    boolean close();
}
