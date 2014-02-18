package com.gawekar.spring.config.usevalue;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:contexts/annotations/use-value/fullName-useValue.properties")
public class UseValueConfig {
    @Value("${name}")
    private String name;
    
    @Value("${surname}")
    private String surname;
    
    /**
     * HERE WE HAVE TO EXPLICITLY REGISTER BEAN  PropertySourcesPlaceholderConfigurer
     * @return
     */
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }
    
    
    @Bean 
    public Map<String, String> fullNameMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", name);
        map.put("surname", surname);
        return map;
    }
}
