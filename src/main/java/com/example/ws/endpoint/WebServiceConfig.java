package com.example.ws.endpoint;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

import javax.servlet.Servlet;

@EnableWs
@Configuration
public class WebServiceConfig {

    /**
     * For the example below this is:
     * [host]=”http://localhost:8080”+
     * [servlet mapping uri]=”/codenotfound/ws/”+
     * [WsdlDefinition bean name]=”helloworld”+
     * [WSDL postfix]=”.wsdl”.
     * <p>
     * Or: http://localhost:8080/codenotfound/ws/helloworld.wsdl.
     *
     * @param applicationContext 应用上下文类
     * @return 返回结果
     */

    @Bean
    public ServletRegistrationBean<Servlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet =
                new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean<>(servlet,
                "/codenotfound/ws/*");
    }

    @Bean(name = "helloworld")
    public Wsdl11Definition defaultWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition =
                new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/helloworld.wsdl"));
        return wsdl11Definition;
    }

    @Bean(name = "test")
    public Wsdl11Definition testWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition =
                new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/CO_FNDEI_UNITOFMEASUREMENT_RL.wsdl"));
        return wsdl11Definition;
    }

}
