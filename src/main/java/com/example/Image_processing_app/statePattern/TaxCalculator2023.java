package com.example.Image_processing_app.statePattern;

public class TaxCalculator2023 implements TaxCalculator {
    @Override
    public int calculate(int price) {
        System.out.println("Adding tax for year 2023");
        return price+10;
    }
}
