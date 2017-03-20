package jdk8demo.interfaces;

/**
 * Created by Andrew  on 2017/3/16.
 */
public interface D {
    default void hello() {
        System.out.println("hello world from D");
    }
}
