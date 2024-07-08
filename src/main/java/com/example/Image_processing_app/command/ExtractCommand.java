package com.example.Image_processing_app.command;

public class ExtractCommand implements Command{

    ImageProcess imageProcess;

    public ExtractCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    @Override
    public void execute(String command, String pattern) {
        imageProcess.handleExtend(command, pattern);
    }
}
