package complex.tool;

import complex.service.Observer;
import complex.service.Quackable;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class QuackCounter implements Quackable{
    Quackable duck;
    static  int numberOfQuackers;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuackers++;
    }

    public static int getNumberOfQuackers() {
        return numberOfQuackers;
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
