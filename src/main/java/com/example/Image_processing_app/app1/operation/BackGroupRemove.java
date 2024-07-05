package com.example.Image_processing_app.app1.operation;

import com.example.Image_processing_app.app1.Image;
import com.example.Image_processing_app.app1.adpter.ThirdParty;
import com.example.Image_processing_app.app1.decorator.OperationDecorator;

public class BackGroupRemove extends OperationDecorator {
    private ThirdParty thirdParty;

    public BackGroupRemove(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

    public BackGroupRemove(ThirdParty thirdParty, Operation operation) {
        super(operation);
        this.thirdParty = thirdParty;
    }

    @Override
    public void process(Image image) {
        int charges = charges();
        image.setChargesForProcessing(charges);
        if(operation != null) operation.process(image);
        thirdParty.removeBackground(image);
    }

    @Override
    public int charges() {
        int charges = 0;
        if(operation != null) charges+=operation.charges();
            return charges + thirdParty.chargesForRemovingBackground();
    }

//    @Override
//    public void pay() {
//        this.
//    }
}
