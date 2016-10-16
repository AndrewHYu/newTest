package complex.factory;

import complex.service.Quackable;
import complex.service.impl.DuckCall;
import complex.service.impl.MallardDuck;
import complex.service.impl.RedHeadDuck;
import complex.service.impl.RubberDuck;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class DuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
}
