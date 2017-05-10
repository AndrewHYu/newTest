package factory.BuilderPattern;

/**
 * Created by Andrew  on 2017/5/7.
 */
public class MainTest {
    public static void main(String[] args) {
        NutritionFact cocaCola = new NutritionFact.Builder(240,8).
                calories(100).sodium(35).calories(27).build();
    }
}
