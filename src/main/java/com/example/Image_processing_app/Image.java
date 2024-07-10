package com.example.Image_processing_app;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {

    private String name;

    public Image(String name, byte[] image, String formate, String height, String width) {
        this.name = name;
        this.image = image;
        this.formate = formate;
        this.height = height;
        this.width = width;
    }

    private byte[] image;

    public Image(String name, byte[] image, String formate) {
        this.name = name;
        this.image = image;
        this.formate = formate;
    }

    private String formate;
    private String height;
    private String width;
    private int chargesForProcessing;
}
