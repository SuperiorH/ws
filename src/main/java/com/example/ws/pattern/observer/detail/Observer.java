package com.example.ws.pattern.observer.detail;

public abstract class Observer {
    protected String name;
    protected Subject subject;

    public Observer(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    abstract void update();

}

