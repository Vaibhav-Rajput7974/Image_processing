package com.example.Image_processing_app.adpter;

import com.example.Image_processing_app.Image;
import com.example.Image_processing_app.statePattern.TaxCalculator;
import com.example.Image_processing_app.statePattern.TaxCalculator2024;
import com.example.Image_processing_app.stratage.AwsService;
import com.example.Image_processing_app.stratage.ServiceProvider;

public class Adapter implements ThirdParty {
    // in the adpater we can make changes accorinding to the tax year

    ServiceProvider serviceProvider;

    TaxCalculator tax = new TaxCalculator2024();
    // we will change the tax year according to the tax year, it is the implementation of state pattern

    public Adapter(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public void removeBackground(Image image) {
        serviceProvider.removeBackground(image);
    }

    @Override
    public void crop(Image image) {
        serviceProvider.crop(image);
    }

    @Override
    public void generateAi(Image image) {
        serviceProvider.generateAi(image);
    }

    @Override
    public void resize(Image image) {
        serviceProvider.resize(image);
    }

    @Override
    public void objectDetection(Image image) {
        serviceProvider.objectDetection(image);
    }

    @Override
    public int chargesForRemovingBackground() {
        return tax.calculate(serviceProvider.chargesForRemovingBackground());
    }

    @Override
    public int chargesForCropingImage() {
        return tax.calculate(serviceProvider.chargesForCropingImage());
    }

    @Override
    public int chargesForGeneratingAl() {
        return tax.calculate(serviceProvider.chargesForGeneratingAl());
    }

    @Override
    public int chargesForResizingImage() {
        return tax.calculate(serviceProvider.chargesForResizingImage());
    }

    @Override
    public int chargesForObjectDetection() {
        return tax.calculate(serviceProvider.chargesForObjectDetection());
    }

    public static Adapter getAdapter() {
        ServiceProvider awsService = new AwsService();
        Adapter adapter = new Adapter(awsService); // adptor patter
        return adapter;
    }

}
