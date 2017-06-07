package packing;

/**
 * Created by Andrew  on 2016/9/8.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description="House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
