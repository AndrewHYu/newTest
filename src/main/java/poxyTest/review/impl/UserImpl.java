package poxyTest.review.impl;

import poxyTest.review.inter.User;

/**
 * Created by Andrew  on 2016/10/13.
 */
public class UserImpl implements User {
    @Override
    public void saySomething() {
        System.out.println("Hello everyBody!");
    }
}
