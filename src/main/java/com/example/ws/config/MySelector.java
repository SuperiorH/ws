package com.example.ws.config;

import com.example.ws.domain.Bus;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("1111");
        importingClassMetadata.getAnnotationTypes().forEach(System.out::println);
        System.out.println("2222");
        return new String[]{Bus.class.getName()};
    }
}
