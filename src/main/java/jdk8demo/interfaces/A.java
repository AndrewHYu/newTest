package jdk8demo.interfaces;

/**
 * Created by Andrew  on 2017/3/16.
 */
public interface A {
    void doSomething();

    default void hello() {
        System.out.println("hello world from interface A");
    }

    default void foo() {
        System.out.println("foo from interface A");
    }
}
