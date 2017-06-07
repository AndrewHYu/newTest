package complex.service.impl;

import complex.service.Observer;
import complex.service.Quackable;
import complex.service.observerImpl.Observable;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class RedHeadDuck implements Quackable {
    Observable observable;

    public RedHeadDuck() {
        this.observable = new Observable(this);
    }
    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }
    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
