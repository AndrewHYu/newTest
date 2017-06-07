package factory;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.NotThreadSafe;

/**
 * Created by Andrew  on 2016/9/10.
 */

public abstract class PizzaStore {
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza=createPizza(type);

        return pizza;
    }
   abstract Pizza createPizza(String type);
}
