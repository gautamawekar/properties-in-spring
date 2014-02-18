package com.gawekar.spring.config.useenvironment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:contexts/annotations/use-environment/fullName-useEnviornment.properties")
public class UseEnvironmentConfig {
    @Autowired private Environment env;
    
    @Bean 
    public Map<String, String> fullNameMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", env.getProperty("name"));
        map.put("surname", env.getProperty("surname"));
        return map;
    }
    
}
