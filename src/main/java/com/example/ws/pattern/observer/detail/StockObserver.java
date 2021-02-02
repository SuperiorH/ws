package com.example.ws.pattern.observer.detail;

public class StockObserver extends Observer {

    public StockObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    void update() {
        System.out.println(subject.getAction() + "\n" + name + "关闭股票行情，继续工作");
    }
}
