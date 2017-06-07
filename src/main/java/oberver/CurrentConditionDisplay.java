package oberver;

/**
 * Created by Andrew  on 2016/9/3.
 */
public class CurrentConditionDisplay implements Observer,DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherDate;
    public CurrentConditionDisplay(Subject weatherDate){
        this.weatherDate=weatherDate;
        weatherDate.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Current conditions:"+temperature+"F degrees and "+humidity+"%humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        display();
    }
}
