package com.example.ws;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WsApplication.class)
class WsApplicationTests {

    @Test
    public void contextLoads() {
        new Thread(() -> System.out.println(123 + " " +
                Thread.currentThread().getName()),
                "Thread-" + UUID.randomUUID()).start();
    }

    @Test
    @DisplayName("测试断言equals")
    void testEquals() {
        System.out.println("start...");
//        assertTrue(3 < 4);
        assertTrue(3 >= 4);
        System.out.println("end...");
    }

    @Test
    @DisplayName("测试断言NotNull")
    void testNotNull() {
        System.out.println("start...");
//        assertNotNull(new Object());
        assertNotNull(null);
        System.out.println("end...");

    }

    @Test
    @DisplayName("测试断言抛异常")
    void testThrows() {
        ArithmeticException arithExcep = assertThrows(ArithmeticException.class, () -> {
            int m = 5 / 0;
        });
        assertEquals("/ by zero", arithExcep.getMessage());
    }

    @Test
    @DisplayName("测试断言超时")
    void testTimeOut() {
        String actualResult = assertTimeout(ofSeconds(2), () -> {
//            Thread.sleep(1000);
            Thread.sleep(3000);
            return "a result";
        });
        System.out.println(actualResult);
    }

    @Test
    @DisplayName("测试组合断言")
    void testAll() {
        assertAll("测试item商品下单",
                () -> {
                    //模拟用户余额扣减
                    assertTrue(1 < 2, "余额不足");
                },
                () -> {
                    //模拟item数据库扣减库存
                    assertTrue(3 < 4);
                },
                () -> {
                    //模拟交易流水落库
                    assertNotNull(new Object());
                }
        );
    }

    @RepeatedTest(3)
    @DisplayName("重复测试")
    void repeatedTest() {
        System.out.println("调用");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("参数化测试")
    void paramTest(int a) {
        assertTrue(a > 0 && a < 4);
    }

    @SpringBootTest
    @AutoConfigureMockMvc
    @DisplayName("Junit5单元测试")
    public class MockTest {
        //....
        @Nested
        @DisplayName("内嵌订单测试")
        class OrderTestClass {
            @Test
            @DisplayName("取消订单")
            void cancelOrder() {
                int status = -1;
                System.out.println("取消订单成功,订单状态为:" + status);
            }
        }
    }

}
