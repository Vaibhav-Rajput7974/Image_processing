package com.example.Image_processing_app;

import com.example.Image_processing_app.command.Command;
import com.example.Image_processing_app.command.CropCommand;
import com.example.Image_processing_app.command.ExtractCommand;
import com.example.Image_processing_app.command.ImageProcess;
import com.example.Image_processing_app.command.RemoveBgCommand;
import com.example.Image_processing_app.command.ResizeCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandDecoder {

    public static void parseCommand(String command) {
        String resizePattern = "resize --width (\\d+) --height (\\d+) (.+)";
        String extendPattern = "extend --direction (\\w+) --pixels (\\d+) (.+)";
        String cropPattern = "crop --top (\\d+) --right (\\d+) --bottom (\\d+) --left (\\d+) (.+)";
        String removeBgPattern = "remove-bg (.+)";
        String combinePattern = "combine (.*) (.+)";
        String commandType = command.split(" ")[0];
        ImageProcess imageProcess = new ImageProcess();
        switch (commandType) {
            case "resize":
                 new ResizeCommand(imageProcess).execute();
                break;
            case "extend":
                new ExtractCommand(imageProcess).execute();
                break;
            case "crop":
                new CropCommand(imageProcess).execute();
                break;
            case "remove-bg":
                new RemoveBgCommand(imageProcess).execute();
                break;
            case "combine":
                handleCombine(command,combinePattern);
                break;
            default:
                System.out.println("Command not recognized: " + command);
        }

        System.out.println("--------------");
    }

    public static void handleCombine(String command, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(command);
        if (matcher.matches()) {
            String operations = matcher.group(1).trim();
            String fileName = matcher.group(2).trim();
            System.out.println("Command: ");

            // Split the string using the pattern "--operation"
            String[] splitOperations = operations.split("--operation\\d+ ");

            // Print the split operations

            Command decoratedCommand = null;
            for (String operation : splitOperations) {
                Command currentCommand = null;
                switch (operation) {

                    case "resize":
                        currentCommand = new ResizeCommand(new ImageProcess());
                        break;
                    case "extend":
                        currentCommand = new ExtractCommand(new ImageProcess());
                        break;
                    case "crop":
                        currentCommand = new CropCommand(new ImageProcess());
                        break;
                    case "remove-bg":
                        currentCommand = new RemoveBgCommand(new ImageProcess());
                        break;
                }
                if (decoratedCommand == null) {
                    decoratedCommand = currentCommand;
                } else {
                    decoratedCommand.addCommand(currentCommand);
                }
            }
            if (decoratedCommand != null)
                decoratedCommand.execute();
        }
    }
}
