package com.example.Image_processing_app.app1.adpter;

import com.example.Image_processing_app.app1.Image;

public interface ThirdParty {
    void removeBackground(Image image);

    void crop(Image image);

    void generateAi(Image image);

    void resize(Image image);

    void objectDetection(Image image);

    int chargesForRemovingBackground();

    int chargesForCropingImage();

    int chargesForGeneratingAl();

    int chargesForResizingImage();

    int chargesForObjectDetection();


}
