package com.example.abstractfactoryexample;

public class MacBook implements Laptop{
    @Override
    public void typing() {
        System.out.println("Typing MacBook.");
    }
}
