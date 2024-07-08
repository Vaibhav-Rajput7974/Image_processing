package com.example.Image_processing_app.statePattern;

public class Card implements PaymentPlateForm {
    @Override
    public void pay(int amount) {
        System.out.println("Paying "+amount+" using the card");
    }
}
