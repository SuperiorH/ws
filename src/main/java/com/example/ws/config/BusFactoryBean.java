package com.example.ws.config;

import com.example.ws.domain.Bus;
import org.springframework.beans.factory.FactoryBean;

import java.util.Date;

public class BusFactoryBean implements FactoryBean<Bus> {
    @Override
    public Bus getObject() {
        System.out.println("被初始化啦。。。。");
        Bus bus = new Bus();
        bus.setName("Joe");
        bus.setStartTime(new Date());
        return bus;
    }

    @Override
    public Class<?> getObjectType() {
        return Bus.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
