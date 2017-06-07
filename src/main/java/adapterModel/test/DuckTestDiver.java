package adapterModel.test;

import adapterModel.adapter.TurkeyAdapter;
import adapterModel.impl.MallardDuck;
import adapterModel.impl.WildTurkey;
import adapterModel.inter.Duck;

/**
 * Created by Andrew  on 2016/9/26.
 * https://github.com/AndrewHYu/newTest.git
 */
public class DuckTestDiver {
    public static void main(String[] args) {
        MallardDuck duck=new MallardDuck();

        WildTurkey turkey=new WildTurkey();
        Duck turkeyAdapter =new TurkeyAdapter(turkey);

        System.out.println("The Turkey say.....");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck say....");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter say....");
        testDuck(turkeyAdapter);
    }
    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
