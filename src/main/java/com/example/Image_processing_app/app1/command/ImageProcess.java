package com.example.Image_processing_app.app1.command;

import com.example.Image_processing_app.app1.Image;
import com.example.Image_processing_app.app1.ImageProcessing;
import com.example.Image_processing_app.app1.adpter.Adapter;
import com.example.Image_processing_app.app1.operation.BackGroupRemove;
import com.example.Image_processing_app.app1.operation.Crop;
import com.example.Image_processing_app.app1.operation.GenerateAl;
import com.example.Image_processing_app.app1.operation.ObjectDetection;
import com.example.Image_processing_app.app1.operation.Operation;
import com.example.Image_processing_app.app1.operation.Resize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageProcess {

    public void handleCombine(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String operations = matcher.group(1).trim();
            String fileName = matcher.group(2).trim();
            System.out.println("Command: ");

            // Split the string using the pattern "--operation"
            String[] splitOperations = operations.split("--operation\\d+ ");

            // Print the split operations

            Operation decoratedOperation = null;
            for (String operation : splitOperations) {
                Operation currentOperation = null;
                switch (operation) {

                    case "resize":
                        currentOperation = new Resize(Adapter.getAdapter());
                        break;
                    case "extend":
                        currentOperation = new GenerateAl(Adapter.getAdapter());
                        break;
                    case "crop":
                        currentOperation = new Crop(Adapter.getAdapter());
                        break;
                    case "remove-bg":
                        currentOperation = new BackGroupRemove(Adapter.getAdapter());
                        break;
                }
                if (decoratedOperation == null) {
                    decoratedOperation = currentOperation;
                } else {
                    decoratedOperation.addOperation(currentOperation);
                }
            }
            if (decoratedOperation != null)
                decoratedOperation.process(new Image(fileName, null, "JPG", "12", "12"));
        }
    }


    public void handleResize(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String width = matcher.group(1);
            String height = matcher.group(2);
            String fileName = matcher.group(3);
            Operation resize = new Resize(Adapter.getAdapter());
            ImageProcessing imageProcessing = new ImageProcessing(resize);
            imageProcessing.push(new Image(fileName,null,"JPG",height,width));
            imageProcessing.start();
        }
    }

    public void handleCrop(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String top = matcher.group(1);
            String right = matcher.group(2);
            String bottom = matcher.group(3);
            String left = matcher.group(4);
            String fileName = matcher.group(5);
            Operation resize = new Crop(Adapter.getAdapter());
            ImageProcessing imageProcessing = new ImageProcessing(resize);
            imageProcessing.push(new Image(fileName,null,"JPG","0","100"));
            imageProcessing.start();
        }
    }


    public void handleExtend(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String direction = matcher.group(1);
            String pixels = matcher.group(2);
            String fileName = matcher.group(3);
            Operation resize = new ObjectDetection(Adapter.getAdapter());
            ImageProcessing imageProcessing = new ImageProcessing(resize);
            imageProcessing.push(new Image(fileName,null,"JPG","0","100"));
            imageProcessing.start();
        }
    }

    public void handleRemoveBg(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String fileName = matcher.group(1);
            Operation resize = new BackGroupRemove(Adapter.getAdapter());
            ImageProcessing imageProcessing = new ImageProcessing(resize);
            imageProcessing.push(new Image(fileName,null,"JPG","0","100"));
            imageProcessing.start();
        }
    }

}
