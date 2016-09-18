package oberver;

/**
 * Created by Andrew  on 2016/9/6.
 */
public class WeatherStation {
    public static void main(String[]args){
        WeatherData weatherData=new WeatherData();
        CurrentConditionDisplay currentConditionDisplay=new CurrentConditionDisplay(weatherData);


        weatherData.setMeasurementsChanged(80,65,30.4f);
        weatherData.setMeasurementsChanged(82,70,29.2f);
        weatherData.setMeasurementsChanged(78,90,29.2f);
    }
}
