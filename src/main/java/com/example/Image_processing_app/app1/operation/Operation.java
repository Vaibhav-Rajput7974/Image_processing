package com.example.Image_processing_app.app1.operation;

import com.example.Image_processing_app.app1.Image;

public interface Operation {
    void process(Image image);
    int charges();

    void addOperation(Operation operation);

}
