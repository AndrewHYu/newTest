package complex.otherAnimal.adatper;

import complex.otherAnimal.Goose;
import complex.service.Observer;
import complex.service.Quackable;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class GooseAdatper implements Quackable {
    Goose goose;

    public GooseAdatper(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
