package com.example.Image_processing_app.command;

public class removeBgCommand implements Command {
    ImageProcess imageProcess;

    public removeBgCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    @Override
    public void execute(String command, String pattern) {
        imageProcess.handleRemoveBg(command, pattern);
    }
}
