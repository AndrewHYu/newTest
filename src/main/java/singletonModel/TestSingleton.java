package singletonModel;

/**
 * Created by Andrew  on 2016/9/19.
 */
public class TestSingleton {
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        Singleton.getInstance();
                    }
                }
            }).start();
        }
    }
}
