package packing;

/**
 * Created by Andrew  on 2016/9/8.
 */
public class Decaf extends Beverage {
    public Decaf() {
        description="Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
