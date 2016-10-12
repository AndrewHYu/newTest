package ModelModel.second;

/**
 * Created by Andrew  on 2016/10/11.
 */
public abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater(){
        System.out.println("Boiling Water");
    }
    void pourInCup(){
        System.out.println("pouring into cup");
    }
}
