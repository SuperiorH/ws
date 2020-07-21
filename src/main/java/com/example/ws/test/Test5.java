package com.example.ws.test;

public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我睡了一段时间:" + Thread.currentThread().getName());
        }, "thread-1");
        t1.start();
//        t1.join();
        System.out.println("程序执行完毕");
    }
}
