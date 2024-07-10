package com.example.Image_processing_app.command;

import com.example.Image_processing_app.observer.Subject;

public class CropCommand extends CombineCommand {
    ImageProcess imageProcess;

    public CropCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    public CropCommand(Command command){
        super(command);
        imageProcess = new ImageProcess();
    }

    @Override
    public void execute() {
        super.execute();
        imageProcess.handleCrop();
    }
}
