package packing;

/**
 * Created by Andrew  on 2016/9/8.
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+"Whip";
    }

    @Override
    public double cost() {
        return 0.10+beverage.cost();
    }
}
