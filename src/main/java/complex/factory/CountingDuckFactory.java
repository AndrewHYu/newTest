package complex.factory;

import complex.service.Quackable;
import complex.service.impl.DuckCall;
import complex.service.impl.MallardDuck;
import complex.service.impl.RedHeadDuck;
import complex.service.impl.RubberDuck;
import complex.tool.QuackCounter;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class CountingDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounter(new RedHeadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
