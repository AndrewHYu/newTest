package complex.service.observerImpl;

import complex.service.Observer;
import complex.service.QuackObservable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class Observable implements QuackObservable {
    List observers= new ArrayList();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator iterator=observers.iterator();
        while (iterator.hasNext()){
            Observer observer=(Observer)iterator.next();
            observer.update(duck);
        }
    }
}
