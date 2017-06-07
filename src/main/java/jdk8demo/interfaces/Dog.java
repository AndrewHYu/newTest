package jdk8demo.interfaces;

/**
 * Created by Andrew  on 2017/3/16.
 */
public class Dog implements Animal {
    public void sayHi() {
        System.out.println("dog");
    }

    public static void main(String args[]) {
        Dog dog = new Dog();
        dog.eat();
    }
}
