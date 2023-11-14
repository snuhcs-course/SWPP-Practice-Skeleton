package com.example.abstractfactoryexample;

public class iPad implements Tablet{
    @Override
    public void touch() {
        System.out.println("Touch iPad.");
    }
}
