package com.example.ws.pattern.command;

public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.exe();
    }

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command myCommand = new MyCommand(receiver);
        Invoker invoker = new Invoker(myCommand);
        invoker.action();
    }

}

interface Command {
    void exe();
}

class MyCommand implements Command {
    
    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }

}

class Receiver {
    public void action() {
        System.out.println("command received!");
    }
}
