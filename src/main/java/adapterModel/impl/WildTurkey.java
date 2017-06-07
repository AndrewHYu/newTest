package adapterModel.impl;

import adapterModel.inter.Turkey;

/**
 * Created by Andrew  on 2016/9/26.
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I am flying a short distance");
    }
}
