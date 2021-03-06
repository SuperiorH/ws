package com.example.ws.pattern.chain;

import java.util.Objects;

public class HandlerA extends Handler {
    @Override
    String handleRequest(String msg) {
        if (msg.contains("a")) {
            msg = msg.replace("a", "*");
        } else if (Objects.nonNull(this.successor)) {
            msg = successor.handleRequest(msg);
        }
        return msg;
    }
}
