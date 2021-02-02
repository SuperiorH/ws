package com.example.ws.pattern.chain;

import java.util.Objects;

public class HandlerB extends Handler {
    @Override
    String handleRequest(String msg) {
        if (msg.contains("b")) {
            msg = msg.replace("b", "*");
        } else if (Objects.nonNull(this.successor)) {
            msg = successor.handleRequest(msg);
        }
        return msg;
    }
}
