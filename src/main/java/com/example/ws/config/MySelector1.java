package com.example.ws.config;

import com.example.ws.domain.Bus;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MySelector1 implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (registry.containsBeanDefinition("car1")) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Bus.class);
            registry.registerBeanDefinition("bus", rootBeanDefinition);
        }
    }

}
