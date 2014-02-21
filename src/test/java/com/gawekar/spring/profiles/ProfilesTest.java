package com.gawekar.spring.profiles;

import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfilesTest {
    @Test
    public void enableOnlyOneProfile() {
        System.setProperty("spring.profiles.active", "test1");
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("contexts/profiles/profile-xml-configuration.xml");
        Map<String, String> fullName = context.getBean("fullName",Map.class);
        TestCase.assertEquals("gautam from profile test1", fullName.get("name"));
        TestCase.assertEquals("Awekar from profile test1", fullName.get("surname"));
        System.clearProperty("spring.profiles.active");
    }
    
    @Test(expected = NoSuchBeanDefinitionException.class)
    public void noBeanFromOtherProfileShouldBeLoaded() {
        System.setProperty("spring.profiles.active", "test1");
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("contexts/profiles/profile-xml-configuration.xml");
        context.getBean("fullName-test2",Map.class);
        System.clearProperty("spring.profiles.active");
    }
    
    @Test
    public void enableMoreThanOneProfile() {
        System.setProperty("spring.profiles.active", "test1,test2");
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("contexts/profiles/profile-xml-configuration.xml");
        Map<String, String> fullName = context.getBean("fullName",Map.class);
        Map<String, String> fullName2 = context.getBean("fullName-test2",Map.class);
        TestCase.assertEquals("gautam from profile test1", fullName.get("name"));
        TestCase.assertEquals("Awekar from profile test1", fullName.get("surname"));
        TestCase.assertEquals("gautam from profile test2", fullName2.get("name"));
        TestCase.assertEquals("Awekar from profile test2", fullName2.get("surname"));
        System.clearProperty("spring.profiles.active");
    }
}
