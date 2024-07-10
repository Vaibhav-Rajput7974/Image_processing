package com.example.Image_processing_app.command;

import com.example.Image_processing_app.Image;
import com.example.Image_processing_app.adpter.Adapter;
import com.example.Image_processing_app.adpter.ThirdParty;
import com.example.Image_processing_app.observer.Subject;
import com.example.Image_processing_app.statePattern.PayPal;
import com.example.Image_processing_app.statePattern.PaymentPlateForm;
import com.example.Image_processing_app.stratage.AwsService;

public class ImageProcess extends Subject {

    void pay(int charges){
        PaymentPlateForm paymentPlateForm = new PayPal();
        paymentPlateForm.pay(charges);
    }

    ThirdParty thirdParty = new Adapter(new AwsService());
    public void handleResize() {
        notifyObserver();
        int charges = thirdParty.chargesForResizingImage();
        pay(charges);
        thirdParty.resize(new Image("xyz",null,"jpg"));
    }

    public void handleRemoveBg() {
        notifyObserver();
        int charges = thirdParty.chargesForRemovingBackground();
        pay(charges);
        thirdParty.removeBackground(new Image("xyz",null,"jpg"));
    }

    public void handleExtend(){
        notifyObserver();
        int charges = thirdParty.chargesForGeneratingAl();
        pay(charges);
        thirdParty.generateAi(new Image("xyz",null,"jpg"));
    }

    public void handleCrop(){
        notifyObserver();
        int charges = thirdParty.chargesForCropingImage();
        pay(charges);
        thirdParty.crop(new Image("xyz",null,"jpg"));
    }
}
