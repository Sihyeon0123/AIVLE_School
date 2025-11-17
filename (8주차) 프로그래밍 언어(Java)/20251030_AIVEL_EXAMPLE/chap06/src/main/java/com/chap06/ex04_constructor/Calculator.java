package com.chap06.ex04_constructor;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    public double sum(List<BigDecimal> numbers){
        BigDecimal sum = BigDecimal.ZERO;
        for(BigDecimal num : numbers){
            sum = sum.add(num);
        }

        return sum.doubleValue();
    }
}
