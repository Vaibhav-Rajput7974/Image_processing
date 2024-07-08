package com.example.Image_processing_app;

import com.example.Image_processing_app.command.CombineCommand;
import com.example.Image_processing_app.command.CropCommand;
import com.example.Image_processing_app.command.ExtractCommand;
import com.example.Image_processing_app.command.ImageProcess;
import com.example.Image_processing_app.command.removeBgCommand;
import com.example.Image_processing_app.command.ResizeCommand;

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
                 new ResizeCommand(imageProcess).execute(command,resizePattern);
                break;
            case "extend":
                new ExtractCommand(imageProcess).execute(command,extendPattern);
                break;
            case "crop":
                new CropCommand(imageProcess).execute(command,cropPattern);
                break;
            case "remove-bg":
                new removeBgCommand(imageProcess).execute(command,removeBgPattern);
                break;
            case "combine":
                new CombineCommand(imageProcess).execute(command,combinePattern);
                break;
            default:
                System.out.println("Command not recognized: " + command);
        }

        System.out.println("--------------");
    }
}
