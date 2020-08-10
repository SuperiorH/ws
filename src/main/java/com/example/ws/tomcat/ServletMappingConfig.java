package com.example.ws.tomcat;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>();
    static {
        servletMappingList.add(new ServletMapping("getMoney","/money","com.example.ws.tomcat.GetMoneyServlet"));
        servletMappingList.add(new ServletMapping("helloWorld","/world","com.example.ws.tomcat.HelloWorldServlet"));
    }
}
