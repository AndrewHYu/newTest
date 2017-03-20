package jdk8demo.interfaces;

/**
 * Created by Andrew  on 2017/3/16.
 */
public interface Animal {
    default void eat() {
        System.out.println("animal eat default method");
    }
}
