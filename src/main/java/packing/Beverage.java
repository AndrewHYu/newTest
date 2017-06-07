package packing;

/**
 * Created by Andrew  on 2016/9/8.
 */
public abstract class Beverage {
    String description="Unknown Beverage";
    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
