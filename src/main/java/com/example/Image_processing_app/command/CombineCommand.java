package com.example.Image_processing_app.command;

public class CombineCommand implements Command{

    ImageProcess imageProcess;

    public CombineCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    @Override
    public void execute(String command, String pattern) {
        imageProcess.handleCombine(command, pattern);
    }
}
