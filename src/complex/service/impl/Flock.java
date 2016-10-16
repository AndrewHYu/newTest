package complex.service.impl;

import complex.service.Observer;
import complex.service.Quackable;
import complex.service.observerImpl.Observable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class Flock implements Quackable {
    Observable observable;

    List<Quackable>quackables=new ArrayList<>();
    public void add(Quackable quackable){
        quackables.add(quackable);
    }
//    public Flock(Observable observable) {
//        this.observable = observable;
//    }
    @Override
    public void quack() {
        Iterator<Quackable> iterator=quackables.iterator();
        while (iterator.hasNext()){
            Quackable quackable=(Quackable)iterator.next();
            quackable.quack();
        }
    }
        @Override
        public void registerObserver(Observer observer) {
            Iterator iterator=quackables.iterator();
            while (iterator.hasNext()){
                Quackable duck=(Quackable)iterator.next();
                duck.registerObserver(observer);
            }
        }

        @Override
        public void notifyObservers() {
        }
}
