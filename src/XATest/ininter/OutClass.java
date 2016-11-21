package XATest.ininter;

/**
 * Created by Andrew  on 2016/11/7.
 */
public class OutClass {
    void say(){

    }
    private class InnerClass{
        public InnerClass(){
            System.out.println("InnerClass");
            say();
        }
    }
}
