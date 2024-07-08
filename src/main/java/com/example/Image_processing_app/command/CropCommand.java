package com.example.Image_processing_app.command;

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
