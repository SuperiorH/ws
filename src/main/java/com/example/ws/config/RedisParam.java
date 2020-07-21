package com.example.ws.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisParam {

    private Integer poolMinIdle;

    private Integer poolMaxIdle;

    private Integer poolMaxActive;

    private Long poolMaxWait;

    private String host;

    private Integer port;

    private Integer database;
}
