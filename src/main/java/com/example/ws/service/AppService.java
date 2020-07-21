package com.example.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private Environment environment;

    public Integer getAge() {
        String age = environment.getProperty("stu.age");
        assert age != null;
        return Integer.parseInt(age);
    }


}
