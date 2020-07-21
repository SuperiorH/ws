package com.example.ws.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

public class Test {

    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set() {
        if (Objects.isNull(longLocal.get())) {
            longLocal.set(Thread.currentThread().getId());
        }
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();
        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        Thread thread1 = new Thread(() -> {
            test.set();
            System.out.println(test.getLong());
            System.out.println(test.getString());
        });
        thread1.start();
        thread1.join();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        List<Object> list = new ArrayList<>();
        List<Object> list1 = new LinkedList<>();
        System.out.println(list instanceof RandomAccess);
        System.out.println(list1 instanceof RandomAccess);
        String str = null;
        System.out.println(Objects.equals(str, "123"));
    }
}
