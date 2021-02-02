package com.example.ws.pattern.chain;

public class Client {

    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);
        System.out.println(handlerA.handleRequest("apple"));
        System.out.println(handlerA.handleRequest("bicycle"));
        System.out.println(handlerA.handleRequest("cherry"));
    }
}
