package ModelModel.second;

/**
 * Created by Andrew  on 2016/10/11.
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Add Sugar and milk");
    }
}
