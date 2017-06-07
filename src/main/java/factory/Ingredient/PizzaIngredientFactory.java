package factory.Ingredient;

import factory.Ingredient.material.*;

/**
 * Created by Andrew  on 2016/9/12.
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams creeateClams();
}
