package com.example.ws.pattern.observer;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.addObserver(new ConcreteObserver());
        concreteSubject.doSomething();
    }
}
