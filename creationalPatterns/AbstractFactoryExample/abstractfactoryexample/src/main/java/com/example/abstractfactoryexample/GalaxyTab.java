package com.example.abstractfactoryexample;

public class GalaxyTab implements Tablet{
    @Override
    public void touch() {
        System.out.println("Touch Galaxy Tab.");
    }
}
