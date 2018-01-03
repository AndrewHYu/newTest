package java8.Java8InAction.chap9;

/**
 * @author Andrew
 * @date 2017/12/25
 *
 * 若D为抽象类，hello为抽象方法则在子类中应该提供实现
 */
public class D implements A {

    @Override
    public void hello() {
        System.out.println("Hello, this is D");
    }
}
