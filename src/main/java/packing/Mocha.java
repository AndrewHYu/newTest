package packing;

/**
 * Created by Andrew  on 2016/9/8.
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+"Mocha";
    }

    @Override
    public double cost() {
        return 0.20+beverage.cost();
    }
}
