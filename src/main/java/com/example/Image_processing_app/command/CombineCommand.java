package com.example.Image_processing_app.command;

public abstract class CombineCommand implements Command {

    protected Command command;

    public CombineCommand(Command command) {
        this.command = command;
    }

    protected CombineCommand() {
    }

    @Override
    public void addCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        if(command != null)
            command.execute();
    }

}
