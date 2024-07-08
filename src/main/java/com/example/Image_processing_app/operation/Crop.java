package com.example.Image_processing_app.operation;

import com.example.Image_processing_app.Image;
import com.example.Image_processing_app.adpter.ThirdParty;
import com.example.Image_processing_app.decorator.OperationDecorator;

public class Crop extends OperationDecorator {

    private ThirdParty thirdParty;

    public Crop(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

    public Crop(Operation operation, ThirdParty thirdParty) {
        super(operation);
        this.thirdParty = thirdParty;
    }

    @Override
    public void process(Image image) {
        int charges = charges();
        pay(charges);
        image.setChargesForProcessing(charges);
        if(operation != null) operation.process(image);
        thirdParty.crop(image);
    }

    @Override
    public int charges() {
        int charges = 0;
        if(operation != null) charges+=operation.charges();
        return charges + thirdParty.chargesForCropingImage();
    }
}
