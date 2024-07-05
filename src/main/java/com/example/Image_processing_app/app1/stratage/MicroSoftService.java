package com.example.Image_processing_app.app1.stratage;

import com.example.Image_processing_app.app1.Image;

public class MicroSoftService implements ServiceProvider {
    @Override
    public void removeBackground(Image image){
        System.out.println("Removing background from the Image : "+image.getName()+" Using Microsoft");
    }

    @Override
    public void  crop(Image image){
        System.out.println("Croping the image with the name : "+image.getName()+" Using Microsoft");
    }

    @Override
    public void  generateAi(Image image){
        System.out.println("Generating Al for the Image "+image.getName()+" Using Microsoft");
    }

    @Override
    public void  resize(Image image){
        System.out.println("Resizing the Image with the Name"+image.getName()+" Using Microsoft");
    }

    @Override
    public void objectDetection(Image image) {
        System.out.println("Detecting Image from the Image: "+image.getName()+ " Using Microsoft");
    }

    @Override
    public int chargesForRemovingBackground() {
        return 1;
    }

    @Override
    public int chargesForCropingImage() {
        return 2;
    }

    @Override
    public int chargesForGeneratingAl() {
        return 10;
    }

    @Override
    public int chargesForResizingImage() {
        return 6;
    }

    @Override
    public int chargesForObjectDetection() {
        return 3;
    }
}
