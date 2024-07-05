package com.example.Image_processing_app.app1.operation;

import com.example.Image_processing_app.app1.Image;
import com.example.Image_processing_app.app1.adpter.ThirdParty;
import com.example.Image_processing_app.app1.decorator.OperationDecorator;

public class GenerateAl extends OperationDecorator {

    private ThirdParty thirdParty;

    public GenerateAl(Operation operation, ThirdParty thirdParty) {
        super(operation);
        this.thirdParty = thirdParty;
    }

    public GenerateAl(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

    @Override
    public void process(Image image) {
        int charges = charges();
        pay(charges);
        image.setChargesForProcessing(charges);
        if(operation != null) operation.process(image);
        thirdParty.generateAi(image);
    }

    @Override
    public int charges() {
        int charges = 0;
        if(operation != null) charges+=operation.charges();
        return charges + thirdParty.chargesForGeneratingAl();
    }
}
