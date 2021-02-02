package com.example.ws.pattern.chain;

import java.util.Objects;

public class HandlerC extends Handler {
    @Override
    String handleRequest(String msg) {
        if (msg.contains("c")) {
            msg = msg.replace("c", "*");
        } else if (Objects.nonNull(this.successor)) {
            msg = successor.handleRequest(msg);
        }
        return msg;
    }
}
