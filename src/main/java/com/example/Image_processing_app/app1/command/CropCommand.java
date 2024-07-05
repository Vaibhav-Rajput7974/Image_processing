package com.example.Image_processing_app.app1.command;

import com.example.Image_processing_app.app1.Image;
import com.example.Image_processing_app.app1.ImageProcessing;
import com.example.Image_processing_app.app1.operation.Crop;
import com.example.Image_processing_app.app1.operation.Operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CropCommand implements Command{
    ImageProcess imageProcess;

    public CropCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    @Override
    public void execute(String command, String pattern) {
        imageProcess.handleCrop(command, pattern);
    }
}
