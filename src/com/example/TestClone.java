package com.example;

/**
 * Created by Andrew  on 2017/5/15.
 */
public class TestClone implements Cloneable{
    private int status;

    public TestClone(int status) {
        this.status = status;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        TestClone test1 = new TestClone(2);
        System.out.println(test1.status);
        try {
            TestClone test2 = (TestClone) test1.clone();
            System.out.println(test2.status);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
