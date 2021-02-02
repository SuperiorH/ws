package com.example.ws.pattern.observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("message received and handle");
    }
}
