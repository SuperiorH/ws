package com.example.ws.proxy;

import com.alibaba.fastjson.JSONArray;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyFactory implements InvocationHandler {
    private Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置操作");
        method.invoke(object, args);
        System.out.println("后置操作");
        return null;
    }

    public <T> T getInstance() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(), this);

    }

    public static void main(String[] args) {
//        MenuService menuService = new MenuServiceImpl();
//        ProxyFactory handler = new ProxyFactory(menuService);
//        MenuService proxyInstance1 = (MenuService) Proxy.newProxyInstance(handler.getClass().getClassLoader(), menuService.getClass().getInterfaces(), handler);
//        MenuService proxyInstance2 = (MenuService) handler.getInstance();
//        proxyInstance1.sayHello();
//        proxyInstance2.sayHello();
//        System.out.println(proxyInstance1.getClass().getName());
//        System.out.println(proxyInstance2.getClass().getName());
    }

}
