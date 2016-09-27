package adapterModel.adapter;

import adapterModel.inter.Duck;
import adapterModel.inter.Turkey;

/**
 * Created by Andrew  on 2016/9/26.
 */
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i=0;i<5;i++){
            turkey.fly();
        }
    }
}
