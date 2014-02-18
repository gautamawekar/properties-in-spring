package com.gawekar.spring.properties;

import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesSettingTest {
    @Test
    public void valuesSetInsideContextFile() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("contexts/non-annotations/hardcoded-properties-context.xml");
        Map<String, String> map = (Map<String, String>)applicationContext.getBean("someMap");
        
        TestCase.assertEquals("Gautam", map.get("name"));
        TestCase.assertEquals("Awekar", map.get("surname"));
    }
    
    @Test
    public void propertyPlaceholderConfigurer() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("contexts/non-annotations/PPConfigurer-spring-context.xml");
        Map<String, String> map = (Map<String, String>)applicationContext.getBean("someMap");
        
        TestCase.assertEquals("Gautam using PropertyPlaceholderConfigurer", map.get("name"));
        TestCase.assertEquals("Awekar using PropertyPlaceholderConfigurer", map.get("surname"));
    }
    
    @Test
    public void propertyPlaceholderConfigurerSystemPassedFile() {
        System.setProperty("propertiesFileName", "contexts/non-annotations/fullName-system-param-passed.properties");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("contexts/non-annotations/PPConfigurer-system-parameter-file-name-spring-context.xml");
        Map<String, String> map = (Map<String, String>)applicationContext.getBean("someMap");
        
        TestCase.assertEquals("Gautam using PropertyPlaceholderConfigurer system", map.get("name"));
        TestCase.assertEquals("Awekar using PropertyPlaceholderConfigurer system", map.get("surname"));
        System.clearProperty("propertiesFileName");
    }
    
    @Test
    public void propertyPlaceholderConfigurerDefaultValues() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("contexts/non-annotations/PPConfigurer-default-values-spring-context.xml");
        Map<String, String> map = (Map<String, String>)applicationContext.getBean("someMap");
        
        TestCase.assertEquals("someDefaultName", map.get("name"));
        TestCase.assertEquals("some default surname", map.get("surname"));
    }
    
    @Test
    public void propertyPlaceholderConfigurerUsingNamespace() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("contexts/non-annotations/PPConfigurer-name-space-spring-context.xml");
        Map<String, String> map = (Map<String, String>)applicationContext.getBean("someMap");
        TestCase.assertEquals("Gautam using PropertyPlaceholderConfigurer namespace", map.get("name"));
        TestCase.assertEquals("Awekar using PropertyPlaceholderConfigurer namespace", map.get("surname"));
    }
}
