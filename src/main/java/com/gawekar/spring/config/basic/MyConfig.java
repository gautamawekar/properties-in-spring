package com.gawekar.spring.config.basic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.gawekar.spring.config.basic.beans")
public class MyConfig {
    @Bean 
    public Map<String, String> fullNameMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "gautam - using java configuration");
        map.put("surname", "awekar - using java configuration");
        return map;
    }
}
