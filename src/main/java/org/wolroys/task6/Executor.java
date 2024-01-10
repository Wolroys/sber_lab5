package org.wolroys.task6;

import org.wolroys.task1.Calculator;
import org.wolroys.task1.CalculatorImpl;

public class Executor {
    public static void main(String[] args) {
        Calculator calculator = PerformanceProxy.createInstance(new CalculatorImpl());
        System.out.println(calculator.calc(3));
    }
}
