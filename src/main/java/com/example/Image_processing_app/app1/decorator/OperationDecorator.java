package com.example.Image_processing_app.app1.decorator;

import com.example.Image_processing_app.app1.Image;
import com.example.Image_processing_app.app1.operation.Operation;


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
}
