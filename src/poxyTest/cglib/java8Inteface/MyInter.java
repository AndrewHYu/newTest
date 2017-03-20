package poxyTest.cglib.java8Inteface;

/**
 * Created by Andrew  on 2017/3/12.
 */
public interface MyInter {
    default void sayHello(){
        System.out.println("hello");
        sayBye();
    }
    static void sayBye(){
        System.out.println("Bye");
    }
}
