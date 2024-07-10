package com.example.Image_processing_app.observer;

public class Logger implements Observer{
    @Override
    public void update() {
        System.out.println("Loging the command");
    }
}
