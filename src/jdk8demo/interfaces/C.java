package jdk8demo.interfaces;

/**
 * Created by Andrew  on 2017/3/16.
 */
public class C implements B,A{
    @Override
    public void doSomething() {
        System.out.println("c object need do something");
    }
    public static void main(String args[]) {
        A obj = new C();
        obj.hello();//调用B的方法
        obj.doSomething();
    }
}
