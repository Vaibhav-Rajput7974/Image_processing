package com.example.Image_processing_app.command;

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
