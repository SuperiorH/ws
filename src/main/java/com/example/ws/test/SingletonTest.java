package com.example.ws.test;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {

    private static SingletonTest demo;

    private SingletonTest() {
    }

//    private static final class InnerClass {
//        private static final SingletonTest demo = new SingletonTest();
//    }

    public synchronized static SingletonTest getInstance() {
        if (Objects.isNull(demo)) {
            demo = new SingletonTest();
        }
        return demo;
//        return InnerClass.demo;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() ->
                    System.out.println("current thread:" + Thread.currentThread().getName() +
                            ", 实例:" + getInstance()));
        }
        executorService.shutdown();
    }
}
