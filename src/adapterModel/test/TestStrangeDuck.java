package adapterModel.test;

import adapterModel.impl.StrangeDuck;
import adapterModel.inter.Duck;
import adapterModel.inter.Turkey;

/**
 * Created by Andrew  on 2016/9/26.
 */
public class TestStrangeDuck {
    public static void main(String[] args) {
        Duck duck=new StrangeDuck();
        Turkey turkey=new StrangeDuck();
    }
}
