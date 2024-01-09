package org.wolroys.task1;

public class Task1Execution {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        System.out.println(calculator.calc(5));
    }
}
