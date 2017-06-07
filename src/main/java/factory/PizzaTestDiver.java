package factory;

/**
 * Created by Andrew  on 2016/9/10.
 */
public class PizzaTestDiver {
    public static void main(String[] args) {
        PizzaStore pizzaStore= new NYPizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}
