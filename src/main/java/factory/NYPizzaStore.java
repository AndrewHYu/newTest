package factory;

/**
 * Created by Andrew  on 2016/9/10.
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza;
        if (type.equals("cheese")){
            pizza=new ChicagoStyleCheesePizza();
        }else{
            pizza=null;
        }
        return pizza;
    }
}
