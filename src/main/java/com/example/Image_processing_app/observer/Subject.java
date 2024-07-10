package com.example.Image_processing_app.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observerList = new ArrayList<>();

    void addObserver(Observer observer){
        observerList.add(observer);
    }

    void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObserver(){
        for(Observer observer : observerList){
            observer.update();
        }
    }
}
