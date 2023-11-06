package com.example.creationalpattern;

public class NetworkLogger {
    public void error(String msg){
        // In practical, the below line is implemented using networking
        System.out.println("Error '" + msg + "' to another server.");
    }
    public void warn(String msg){
        System.out.println("Warn '" + msg + "' to another server.");
    }
    public void info(String msg){
        System.out.println("Info '" + msg + "' to another server.");
    }
    public void debug(String msg){
        System.out.println("Debug '" + msg + "' to another server.");
    }
}
