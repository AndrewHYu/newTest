package ModelModel.first;

/**
 * Created by Andrew  on 2016/10/11.
 */
public class Coffee {
    void prepareRecipe(){
        boilWater();
        brewCoffeeGrinds();
        pourIntCup();
        addSugarAndMilk();
    }
    public void boilWater(){
        System.out.println("Boil water");
    }
    public void brewCoffeeGrinds(){
        System.out.println("Dripping Coffee through filter");
    }
    public void pourIntCup(){
        System.out.println("Pour Into cup");
    }
    public void addSugarAndMilk(){
        System.out.println("Adding Sugar and Milk");
    }
}
