package singletonModel;

/**
 * Created by Andrew  on 2016/9/19.
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;
    private Singleton(){}
    public static Singleton getInstance(){
        if (uniqueInstance==null){
//            synchronized (Singleton.class){
                if (uniqueInstance==null){
                    System.out.println("a new instance has been created");
                    uniqueInstance=new Singleton();
                }
//            }
        }
        return uniqueInstance;
    }
}
