package com.example.Image_processing_app.command;

public class ResizeCommand extends CombineCommand {

    ImageProcess imageProcess;

    public ResizeCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    public ResizeCommand(Command command) {
        super(command);
        imageProcess = new ImageProcess();
    }

    @Override
    public void execute() {
        super.execute();
        imageProcess.handleResize();
    }
}
