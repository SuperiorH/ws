package com.example.ws.pattern.observer.detail;

public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();

    void setAction(String action);

    String getAction();
}
