package com.gawekar.spring.config.useenvironment;

import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseEnvironmentConfigTest {
    @Test
    public void useEnvironment() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("contexts/annotations/use-environment/use-environment.xml");
        Map<String,String> map = ctx.getBean("fullNameMap",Map.class);
        
        TestCase.assertEquals("Gautam using Environment", map.get("name"));
        TestCase.assertEquals("Awekar using Environment", map.get("surname"));
    }
}
