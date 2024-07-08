package com.example.Image_processing_app.operation;

import com.example.Image_processing_app.Image;

public interface Operation {
    void process(Image image);
    int charges();

    void addOperation(Operation operation);

    void pay(int charges);

}
