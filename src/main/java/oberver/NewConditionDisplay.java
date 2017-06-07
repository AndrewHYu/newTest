package oberver;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Andrew  on 2016/9/6.
 */
public class NewConditionDisplay implements Observer,DisplayElement {
    private  float temperature;
    private float humidity;
    private float pressure;
    Observable observable;

    public NewConditionDisplay(Observable observable) {
        this.observable=observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions:"+temperature+"F degrees and "+humidity+"%humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof NewWeatherData){
            NewWeatherData weatherData=(NewWeatherData)o;
            this.temperature=weatherData.getTemperature();
            this.humidity=weatherData.getHumidity();
            display();
        }
    }
}
