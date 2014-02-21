package com.gawekar.spring.util;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PrintContextBeanReport {
    public static void main(String args[]) {
        new GenericXmlApplicationContext("contexts/print-loaded-beans/print*.xml");
    }
    
}
