package com.example.Image_processing_app.app1.statePattern;

import com.example.Image_processing_app.app1.statePattern.TaxCalculator;

public class TaxCalculator2023 implements TaxCalculator {
    @Override
    public int calculate(int price) {
        System.out.println("Adding tax for year 2023");
        return price+10;
    }
}
