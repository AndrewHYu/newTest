package threadPool.schedule;

/**
 * Created by Andrew  on 2017/3/22.
 */
public class ByRunnable implements Runnable {
    private int i=0;

    public ByRunnable(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Runnable Thread "+Thread.currentThread().getName()+" and "+i);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
