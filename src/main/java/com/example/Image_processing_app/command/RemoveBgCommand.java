package com.example.Image_processing_app.command;

public class RemoveBgCommand extends CombineCommand {
    ImageProcess imageProcess ;

    public RemoveBgCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    public RemoveBgCommand(Command command) {
        super(command);
        imageProcess = new ImageProcess();
    }

    @Override
    public void execute() {
        super.execute();
        imageProcess.handleRemoveBg();
    }
}
