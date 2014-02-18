package com.gawekar.spring.config.usevalue;

import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseValueConfigTest {
    @Test
    public void useValue() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "contexts/annotations/use-value/use-value.xml");
        Map<String, String> map = ctx.getBean("fullNameMap", Map.class);

        TestCase.assertEquals("Gautam using @Value", map.get("name"));
        TestCase.assertEquals("Awekar using @Value", map.get("surname"));
    }
}
