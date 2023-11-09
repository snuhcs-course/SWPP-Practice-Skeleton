package com.example.structuralpattern;

public class File {
    private String name;
    public File(String name){
        this.name = name;
    }
    public void info(String prefix){
        System.out.println(prefix + this.name);
    }
}
