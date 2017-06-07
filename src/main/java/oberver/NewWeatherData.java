package oberver;

/**
 * Created by Andrew  on 2016/9/6.
 */
public class NewWeatherData extends java.util.Observable {
    private  float temperature;
    private float humidity;
    private float pressure;

    public NewWeatherData() {
    }

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }
    public void setMeasurementsChanged(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();

    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
