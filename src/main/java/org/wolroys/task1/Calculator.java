package org.wolroys.task1;

import org.wolroys.task6.Metric;

public interface Calculator {

    /**
     * Расчет факториала числа.
     */
    @Metric
    int calc(int number);

}
