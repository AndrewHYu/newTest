package complex.service;


/**
 * Created by Andrew  on 2016/10/15.
 */
public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}
