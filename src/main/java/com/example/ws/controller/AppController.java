package com.example.ws.controller;

import com.example.ws.domain.A;
import com.example.ws.domain.B;
import com.example.ws.domain.Car;
import com.example.ws.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AppController {

    @RequestMapping("h1/{value}")
    public String test(@PathVariable String value) {
        System.out.println(value);
        return "123456";
    }

    @Autowired
    private AppService appService;

    @Autowired
    @Qualifier("car2")
    private Car car;

    @Autowired
    private A a;
    @Autowired
    private B b;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("h2")
    public Integer test1() {
        return appService.getAge();
    }

    @RequestMapping("h3")
    public String test2() {
        return car.toString();
    }

    @RequestMapping("h4")
    public String test3() {
        return "777";
    }

    @RequestMapping("h5")
    public String test4() {
//        Map<String, String> map = new HashMap<>();
//        map.put("2", "2a");
//        map.put("3", "3b");
//        redisTemplate.opsForHash().putAll("h1", map);
        Map<Object, Object> h1 = redisTemplate.boundHashOps("h1").entries();
        System.out.println(h1);
        return "success";
    }

}
