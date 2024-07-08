package com.example.Image_processing_app.decorator;

import com.example.Image_processing_app.Image;
import com.example.Image_processing_app.operation.Operation;
import com.example.Image_processing_app.statePattern.PayPal;
import com.example.Image_processing_app.statePattern.PaymentPlateForm;


public class OperationDecorator implements Operation {

    public OperationDecorator(){

    }

    protected Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public OperationDecorator(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void process(Image image) {
        operation.process(image);
    }

    @Override
    public int charges() {
        return operation.charges();
    }

    @Override
    public void addOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void pay(int charges) {
        PaymentPlateForm paymentPlateForm = new PayPal();
        paymentPlateForm.pay(charges);
    }
}
