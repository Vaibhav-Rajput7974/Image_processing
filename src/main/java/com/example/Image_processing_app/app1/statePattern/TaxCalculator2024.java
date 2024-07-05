package com.example.Image_processing_app.app1.statePattern;

import com.example.Image_processing_app.app1.statePattern.TaxCalculator;

public class TaxCalculator2024 implements TaxCalculator {
    @Override
    public int calculate(int price) {
        return price+100;
    }
}
