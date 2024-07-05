package com.example.Image_processing_app.app1.command;

import com.example.Image_processing_app.app1.Image;
import com.example.Image_processing_app.app1.ImageProcessing;
import com.example.Image_processing_app.app1.operation.Operation;
import com.example.Image_processing_app.app1.operation.Resize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResizeCommand implements Command{

    ImageProcess imageProcess;

    public ResizeCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    @Override
    public void execute(String command, String pattern) {
        imageProcess.handleResize(command, pattern);
    }
}
