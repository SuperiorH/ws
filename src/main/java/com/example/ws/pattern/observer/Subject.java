package com.example.ws.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> list = new ArrayList<>();

    public void addObserver(Observer observer) {
        list.add(observer);
    }

    public void deleteObserver(Observer observer) {
        list.remove(observer);
    }

    public void notifyObserver() {
        list.forEach(Observer::update);
    }
}
