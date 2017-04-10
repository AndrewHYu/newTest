package single;

/**
 * Created by Andrew  on 2017/4/7.
 */
public class SingleClass {
    private volatile static SingleClass singleClass;
    private SingleClass(){

    }
    public  static SingleClass getInstantce(){
        if (singleClass==null){
            synchronized (SingleClass.class){
                if (singleClass==null){
                    singleClass=new SingleClass();
                }
            }
        }
        return singleClass;
    }

}
