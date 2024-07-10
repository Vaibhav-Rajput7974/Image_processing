package com.example.Image_processing_app.command;

public class ExtractCommand extends CombineCommand {

    ImageProcess imageProcess;

    public ExtractCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    public ExtractCommand(Command command) {
        super(command);
        imageProcess = new ImageProcess();
    }

    @Override
    public void execute() {
        super.execute();
        imageProcess.handleExtend();
    }
}
