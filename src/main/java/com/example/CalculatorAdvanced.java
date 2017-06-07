package com.example;

import ClazzLoader.netLoader.ICalculator;

/**
 * Created by Andrew  on 2016/10/9.
 */
public class CalculatorAdvanced implements ICalculator {
    @Override
    public String calculate(String expression) {
        return expression;
    }

    @Override
    public String getVersion() {
        return "2,0";
    }
}
