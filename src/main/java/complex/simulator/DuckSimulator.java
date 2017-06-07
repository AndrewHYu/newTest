package complex.simulator;

import complex.factory.AbstractDuckFactory;
import complex.factory.CountingDuckFactory;
import complex.otherAnimal.Goose;
import complex.otherAnimal.adatper.GooseAdatper;
import complex.service.Quackable;
import complex.service.impl.*;
import complex.service.observerImpl.Quackologist;
import complex.tool.QuackCounter;

/**
 * Created by Andrew  on 2016/10/15.
 */
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator=new DuckSimulator();
        AbstractDuckFactory duckFactory=new CountingDuckFactory();
        duckSimulator.simulate(duckFactory);
    }
    void simulate(AbstractDuckFactory duckFactory){
        Quackable redHeadDuck=duckFactory.createRedHeadDuck();
        Quackable duckCall=duckFactory.createDuckCall();
        Quackable rubberDuck=duckFactory.createRubberDuck();
        //适配器模式
        Quackable gooseDuck=new GooseAdatper(new Goose());

        System.out.println("\nDuck Simulate: With Composite - Flocks");

        Flock flockOfDucks=new Flock();

        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallard=new Flock();

        Quackable mallardOne=duckFactory.createMallardDuck();
        Quackable mallardTwo=duckFactory.createMallardDuck();
        Quackable mallardThree=duckFactory.createMallardDuck();
        Quackable mallardfour=duckFactory.createMallardDuck();

        flockOfMallard.add(mallardOne);
        flockOfMallard.add(mallardTwo);
        flockOfMallard.add(mallardThree);
        flockOfMallard.add(mallardfour);

        flockOfDucks.add(flockOfMallard);
        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: mallard Flock Simulation");
        simulate(flockOfMallard);
//        simulate(mallardDuck);
//        simulate(redHeadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate(gooseDuck);


        System.out.println("\n Duck Simulator: With Observer");
        Quackologist quackologist=new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        simulate(flockOfDucks);

        System.out.println("The ducks quacked "+QuackCounter.getNumberOfQuackers()+" times");
    }
    void simulate(Quackable duck){
        duck.quack();
    }
}
