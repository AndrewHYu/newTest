package oberver;

/**
 * Created by Andrew  on 2016/9/3.
 */
public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();
}
