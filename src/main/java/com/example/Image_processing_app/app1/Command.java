package com.example.Image_processing_app.app1;

import com.example.Image_processing_app.app1.adpter.Adapter;
import com.example.Image_processing_app.app1.operation.*;
import com.example.Image_processing_app.app1.stratage.AwsService;
import com.example.Image_processing_app.app1.stratage.ServiceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {

    public static void parseCommand(String command) {
        String resizePattern = "resize --width (\\d+) --height (\\d+) (.+)";
        String extendPattern = "extend --direction (\\w+) --pixels (\\d+) (.+)";
        String cropPattern = "crop --top (\\d+) --right (\\d+) --bottom (\\d+) --left (\\d+) (.+)";
        String removeBgPattern = "remove-bg (.+)";
        String combinePattern = "combine (.*) (.+)";
        String storePattern = "store --service (\\w+) --(path|bucket) ([^ ]+) --(path|key) ([^ ]+) (.+)";

        // Determine the command type

        String commandType = command.split(" ")[0];
        switch (commandType) {
            case "resize":
                handleResize(command, resizePattern);
                break;
            case "extend":
                handleExtend(command, extendPattern);
                break;
            case "crop":
                handleCrop(command, cropPattern);
                break;
            case "remove-bg":
                handleRemoveBg(command, removeBgPattern);
                break;
            case "combine":
                handleCombine(command, combinePattern);
                break;
            case "store":
                handleStore(command, storePattern);
                break;
            default:
                System.out.println("Command not recognized: " + command);
        }
        System.out.println("--------------");
    }

    private static void handleResize(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String width = matcher.group(1);
            String height = matcher.group(2);
            String fileName = matcher.group(3);
            Operation resize = new Resize(getAdapter());
            ImageProcessing imageProcessing = new ImageProcessing(resize);
            imageProcessing.push(new Image(fileName,null,"JPG",height,width));
            imageProcessing.start();
        }
    }

    private static Adapter getAdapter() {
        ServiceProvider awsService = new AwsService();
        Adapter adapter = new Adapter(awsService); // adptor patter
        return adapter;
    }

    private static void handleExtend(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String direction = matcher.group(1);
            String pixels = matcher.group(2);
            String fileName = matcher.group(3);
            Operation resize = new ObjectDetection(getAdapter());
            ImageProcessing imageProcessing = new ImageProcessing(resize);
            imageProcessing.push(new Image(fileName,null,"JPG","0","100"));
            imageProcessing.start();
        }
    }

    private static void handleCrop(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String top = matcher.group(1);
            String right = matcher.group(2);
            String bottom = matcher.group(3);
            String left = matcher.group(4);
            String fileName = matcher.group(5);
            Operation resize = new Crop(getAdapter());
            ImageProcessing imageProcessing = new ImageProcessing(resize);
            imageProcessing.push(new Image(fileName,null,"JPG","0","100"));
            imageProcessing.start();
        }
    }

    private static void handleRemoveBg(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String fileName = matcher.group(1);
            Operation resize = new BackGroupRemove(getAdapter());
            ImageProcessing imageProcessing = new ImageProcessing(resize);
            imageProcessing.push(new Image(fileName,null,"JPG","0","100"));
            imageProcessing.start();
        }
    }

    private static void handleCombine(String command, String pattern) {
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
                System.out.println(operation);
                switch (operation) {

                    case "resize":
                        currentOperation = new Resize(getAdapter()) ;
                        break;
                    case "extend":
                        currentOperation = new GenerateAl(getAdapter()) ;
                        break;
                    case "crop":
                        currentOperation =  new Crop(getAdapter()) ;
                        break;
                    case "remove-bg":
                        currentOperation = new BackGroupRemove(getAdapter()) ;
                        break;
                }
                if (decoratedOperation == null){
                    decoratedOperation = currentOperation;
                }else {
                    decoratedOperation.addOperation(currentOperation);
                }
            }
            if (decoratedOperation != null)
                decoratedOperation.process(new Image(fileName,null,"JPG","12","12"));
        }
    }

    private static void handleStore(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String service = matcher.group(1);
            String param1 = matcher.group(2);
            String value1 = matcher.group(3);
            String param2 = matcher.group(4);
            String value2 = matcher.group(5);
            String fileName = matcher.group(6);
            Operation resize = new ObjectDetection(getAdapter());
            ImageProcessing imageProcessing = new ImageProcessing(resize);
            imageProcessing.push(new Image(fileName,null,"JPG","0","100"));
            imageProcessing.start();
        }
    }
}
