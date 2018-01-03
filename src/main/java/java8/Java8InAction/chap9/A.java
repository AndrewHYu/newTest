package java8.Java8InAction.chap9;

/**
 * @author Andrew
 * @date 2017/12/25
 */
public interface A {
    default void hello(){
        System.out.println("Hello, this is A");
    }
}
