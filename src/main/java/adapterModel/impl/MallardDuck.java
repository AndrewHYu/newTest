package adapterModel.impl;

import adapterModel.inter.Duck;

/**
 * Created by Andrew  on 2016/9/26.
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I am flying");
    }
}
