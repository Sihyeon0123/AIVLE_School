package com.chap06.ex09_utils;

import com.chap06.ex04_constructor.Calculator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculatorImportMain {
    public static void main(String[] args) {
        List<BigDecimal> nums = new ArrayList<>();
        nums.add(new BigDecimal("10.5"));
        nums.add(new BigDecimal("20.75"));
        nums.add(new BigDecimal("30"));
        // 다른 패키지에 있는 클래스
        // import com.chap06.sub01.Calculator;
        Calculator calc = new Calculator();
        double result = calc.sum(nums);
        System.out.println("총합은 "+result+"입니다.");
    }
}
