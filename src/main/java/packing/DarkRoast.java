package packing;

/**
 * Created by Andrew  on 2016/9/8.
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description="Dark Roast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
