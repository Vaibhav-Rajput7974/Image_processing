package com.example.Image_processing_app.command;

public interface Command {

    void execute();

    void addCommand(Command command);
}
