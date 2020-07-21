package com.example.ws.endpoint;

import com.example.ws.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.codenotfound.types.helloworld.Greeting;
import com.codenotfound.types.helloworld.ObjectFactory;
import com.codenotfound.types.helloworld.Person;

@Endpoint
public class HelloWorldEndpoint {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloWorldEndpoint.class);

    @Autowired
    private AppService service;

//    @Autowired
//    public void setUserService(AppService appService) {
//        service = appService;
//    }

    /**
     * 注解学习
     *
     * @Endpoint 声明用于处理SOAP消息
     * @PayloadRoot 根据namespace和localPart映射对应的处理方法
     * @RequestPayload 声明进来的消息将会与该方法的参数映射
     * @ResponsePayload 方法返回值的映射
     */

    @PayloadRoot(
            namespace = "http://codenotfound.com/types/helloworld",
            localPart = "person")

    @ResponsePayload
    public Greeting sayHello(@RequestPayload Person request) {
        LOGGER.info("Endpoint received person[firstName={},lastName={}]",
                request.getFirstName(), request.getLastName());

        String greeting = "Hello " + request.getFirstName() + " "
                + request.getLastName() + "!";

        ObjectFactory factory = new ObjectFactory();
        Greeting response = factory.createGreeting();
        response.setGreeting(greeting);
        Integer age = service.getAge();
        LOGGER.info("Endpoint sending greeting='{}'",
                response.getGreeting());
        return response;
    }
}
