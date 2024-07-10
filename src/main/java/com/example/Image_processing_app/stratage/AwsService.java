package com.example.Image_processing_app.stratage;

import com.example.Image_processing_app.Image;

public class AwsService implements ServiceProvider {
    @Override
    public void removeBackground(Image image){
        System.out.println("Removing background from the Image : "+image.getName()+" Using AWS ");
    }

    @Override
    public void  crop(Image image){
        System.out.println("Croping the image with the name : "+image.getName()+" Using AWS ");
    }

    @Override
    public void  generateAi(Image image){
        System.out.println("Generating Al for the Image "+image.getName()+" Using AWS " );
    }

    @Override
    public void  resize(Image image){
        System.out.println("Resizing the Image with the Name"+image.getName()+" Using AWS ");
    }

    @Override
    public void objectDetection(Image image) {
        System.out.println("Detecting Image from the Image: "+image.getName()+ " Using AWS ");
    }

    @Override
    public int chargesForRemovingBackground() {
        return 10;
    }

    @Override
    public int chargesForCropingImage() {
        return 20;
    }

    @Override
    public int chargesForGeneratingAl() {
        return 50;
    }

    @Override
    public int chargesForResizingImage() {
        return 30;
    }

    @Override
    public int chargesForObjectDetection() {
        return 100;
    }
}
