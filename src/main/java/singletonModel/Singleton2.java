package singletonModel;

/**
 * Created by Andrew  on 2017/5/5.
 */
public class Singleton2 {
    private static class SingletonHolder{
        private static final Singleton2 INSTANCE  = new  Singleton2();
    }
    private Singleton2(){

    }
    public Singleton2 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
