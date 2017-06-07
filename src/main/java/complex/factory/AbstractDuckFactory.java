package complex.factory;

import complex.service.Quackable;

/**
 * Created by Andrew  on 2016/10/15.
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedHeadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
}
