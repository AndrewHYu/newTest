package poxyTest.review.impl;

import poxyTest.review.inter.People;

/**
 * Created by Andrew  on 2016/10/13.
 */
public class PeopleImpl implements People {
    @Override
    public void getInfo() {
        System.out.println("I'm a good People");
    }

    @Override
    public void test() {
        System.out.println("test");
    }

}
