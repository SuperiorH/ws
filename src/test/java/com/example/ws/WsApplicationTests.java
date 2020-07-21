package com.example.ws;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WsApplication.class)
class WsApplicationTests {

    @Test
    public void contextLoads() {
        new Thread(() -> System.out.println(123 + " " +
                Thread.currentThread().getName()),
                "Thread-" + UUID.randomUUID()).start();
    }


}
