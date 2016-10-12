package ModelModel.first;

/**
 * Created by Andrew  on 2016/10/11.
 */
public class Tea {
    void prepareRecipe(){
        boilWater();
        steepTeaBag();
        pourIntCup();
        addLemon();
    }
    public void boilWater(){
        System.out.println("Boil water");
    }
    public void steepTeaBag(){
        System.out.println("Steep Tea Bag");
    }
    public void pourIntCup(){
        System.out.println("Pour Into cup");
    }
    public void addLemon(){
        System.out.println("Adding Lemon");
    }
}
