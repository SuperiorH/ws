package com.example.ws.pattern.startegy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Context {

    private String type;

    public Context(String type) {
        this.type = type;
    }

    public void contextInterface() {
        Strategy strategy = map.get(type);
        if (Objects.isNull(strategy)) return;
        strategy.algorithmInterface();
    }

    private static Map<String, Strategy> map = new HashMap<>();

    static {
        map.put("A", new StrategyA());
        map.put("B", new StrategyB());
        map.put("C", new StrategyC());
    }

    public static void main(String[] args) {
        Context contextA = new Context("A");
        Context contextB = new Context("B");
        Context contextC = new Context("C");
        Context contextD = new Context("D");
        contextA.contextInterface();
        contextB.contextInterface();
        contextC.contextInterface();
        contextD.contextInterface();
    }

}
