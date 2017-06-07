package ModelModel.third;

/**
 * Created by Andrew  on 2016/10/11.
 */
public abstract class CaffeineBeverageWithHook {
    void prepareRecope(){
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiment()){
            addCondiments();
        }
    }
    abstract void  brew();
    abstract void addCondiments();
    void boilWater(){
        System.out.println("Boiling water");
    }
    void pourInCup(){
        System.out.println("Pouring into cup");
    }
    boolean customerWantsCondiment(){
        return true;
    }
}
