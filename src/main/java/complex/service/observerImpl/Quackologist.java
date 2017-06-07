package complex.service.observerImpl;


import complex.service.Observer;
import complex.service.QuackObservable;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: "+duck+ "just Qucked");
    }
}
