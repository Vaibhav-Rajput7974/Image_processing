package com.example.Image_processing_app.app1.command;

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
