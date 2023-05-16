package com.fundaments.springboot.fundaments.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentSecondImpl implements ComponentDependency {
    @Override
    public void greet() {
        System.out.println(">>>START class ComponentSecondImpl<<<");
    }
}
