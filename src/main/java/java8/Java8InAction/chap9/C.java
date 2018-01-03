package java8.Java8InAction.chap9;

/**
 * @author Andrew
 * @date 2017/12/25
 * (1) 类中的方法优先级最高。类或父类中声明的方法的优先级高于任何声明为默认方法的优先级。
 *(2) 如果无法依据第一条进行判断，那么子接口的优先级更高：函数签名相同时，优先选择
 *    拥有最具体实现的默认方法的接口，即如果B继承了A，那么B就比A更加具体。
 *(3) 最后，如果还是无法判断，继承了多个接口的类必须通过显式覆盖和调用期望的方法，
 *  显式地选择使用哪一个默认方法的实现。新语法：X.super.m(…) X -> className, m -> methodName
 */
public class C extends D implements B {
    public static void main(String[] args) {
        new C().hello();
    }
}
