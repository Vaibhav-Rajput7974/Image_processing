package com.example.Image_processing_app.app1.command;

import com.example.Image_processing_app.app1.Image;
import com.example.Image_processing_app.app1.ImageProcessing;
import com.example.Image_processing_app.app1.operation.BackGroupRemove;
import com.example.Image_processing_app.app1.operation.Operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveBgCommand implements Command {
    ImageProcess imageProcess;

    public RemoveBgCommand(ImageProcess imageProcess) {
        this.imageProcess = imageProcess;
    }

    @Override
    public void execute(String command, String pattern) {
        imageProcess.handleRemoveBg(command, pattern);
    }
}
