package poxyTest.review;

import poxyTest.review.impl.UserImpl;
import poxyTest.review.inter.User;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * Created by Andrew  on 2016/10/13.
 */
public class Test {
    public static void main(String[] args) {
        Object object=new UserImpl();
        try {
            object.getClass().getDeclaredMethod("saySomething").invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(object instanceof User );
        get(new UserImpl());
    }
    public static void get(Object object){
        try {
            object.getClass().getDeclaredMethod("saySomething").invoke(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
