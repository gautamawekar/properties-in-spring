package com.gawekar.spring.config.basic.beans;

import org.springframework.stereotype.Component;

@Component
public class SomeBeanComponent {
    public String getSomeText() {
        return "component scan annotation worked.";
    }
}
