package com.example.ws.config;

import com.example.ws.domain.Bus;
import com.example.ws.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;


@Configuration
//@Import(value = {MySelector1.class})
public class MyConfiguration {

    @Bean
//    @Conditional(value = {BmwCondition.class})
    public Car car1() {
        return new Car("BMW", 1);
    }

    @Bean
//    @Conditional(value = {BenzCondition.class})
    public Car car2() {
        return new Car("BENZ", 2);
    }

    @Bean
    public BusFactoryBean bus() {
        return new BusFactoryBean();
    }


    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        List<String> list = Arrays.asList(beanDefinitionNames);
        System.out.println("start...");
        list.forEach(System.out::println);
        System.out.println("flag...");
//        Car car1 = ac.getBean("car1", Car.class);
//        Car car2 = ac.getBean("car2", Car.class);
        String property = ac.getEnvironment().getProperty("os.name");
        String user = ac.getEnvironment().getProperty("user");
        System.out.println(property);
        System.out.println(user);
        Object bean = ac.getBean("bus");
        Object bean1 = ac.getBean("&bus");
        System.out.println(bean.getClass());
        System.out.println(bean1.getClass());

    }

}
