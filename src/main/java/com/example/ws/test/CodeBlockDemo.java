package com.example.ws.test;

public class CodeBlockDemo {
    {
        System.out.println("初始化代码:" + System.currentTimeMillis());
    }

    CodeBlockDemo() {
        System.out.println("构造器:" + System.currentTimeMillis());
    }

//    static {
//        System.out.println("静态代码块");
//    }

    //运行后输出结果?
    public static void main(String[] args) throws InterruptedException {
//        {
//            int a = 10;            //10
//            System.out.println("局部代码块");
//        }
        new CodeBlockDemo();
        Thread.sleep(2000L);
        new CodeBlockDemo();
//        new CodeBlockDemo();
    }


}