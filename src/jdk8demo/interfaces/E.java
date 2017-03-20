package jdk8demo.interfaces;

/**
 * Created by Andrew  on 2017/3/16.
 */
public interface E {
    default void hello() {
        System.out.println("hello world from E");
    }
}
