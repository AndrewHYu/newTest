package jdk8demo.interfaces;

/**
 * Created by Andrew  on 2017/3/16.
 */
public interface B extends A {
    @Override
    default void hello() {
        System.out.println("hello world from interface B");
        A.super.hello();
        this.foo();
        this.doSomething();
        A.super.foo();
    }
}
