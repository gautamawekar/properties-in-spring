package com.gawekar.spring.config.basic;

import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gawekar.spring.config.basic.beans.SomeBeanComponent;

public class BasicAnnotationBasedConfigurationTest {
    
    @Test
    public void annotationBasedJavaConfig() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(MyConfig.class);
        ctx.refresh();
        Map<String, String> result = (Map<String, String>)ctx.getBean("fullNameMap");
        TestCase.assertEquals("gautam - using java configuration", result.get("name"));
        TestCase.assertEquals("awekar - using java configuration", result.get("surname"));
    }
    
    @Test
    public void annotationBasedConfig() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.gawekar.spring.config.basic");
        Map<String, String> result = (Map<String, String>)ctx.getBean("fullNameMap");
        TestCase.assertEquals("gautam - using java configuration", result.get("name"));
        TestCase.assertEquals("awekar - using java configuration", result.get("surname"));
    }
    
    /**
     * Context file enables annotation config by defining "<context:annotation-config/>". 
     * Later configuration bean needs to be defined explicitly.
     */
    @Test
    public void use_annotation_config_NameSpace(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("contexts/annotations/basic/annotation-config-only.xml");
        Map<String, String> result = (Map<String, String>)ctx.getBean("fullNameMap");
        TestCase.assertEquals("gautam - using java configuration", result.get("name"));
        TestCase.assertEquals("awekar - using java configuration", result.get("surname"));
        
        SomeBeanComponent someBeanComponent = ctx.getBean(SomeBeanComponent.class);
        TestCase.assertEquals("component scan annotation worked.", someBeanComponent.getSomeText());
    }
    
    /**
     * Context file defines <context:component-scan/> ONLY
     */
    @Test
    public void use_component_scan_NameSpace(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("contexts/annotations/basic/component-scan-annotation-config.xml");
        Map<String, String> result = (Map<String, String>)ctx.getBean("fullNameMap");
        TestCase.assertEquals("gautam - using java configuration", result.get("name"));
        TestCase.assertEquals("awekar - using java configuration", result.get("surname"));
        
        SomeBeanComponent someBeanComponent = ctx.getBean(SomeBeanComponent.class);
        TestCase.assertEquals("component scan annotation worked.", someBeanComponent.getSomeText());
    }
}
