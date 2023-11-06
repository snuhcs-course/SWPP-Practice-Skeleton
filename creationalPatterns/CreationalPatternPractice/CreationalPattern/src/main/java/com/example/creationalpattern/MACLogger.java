package com.example.creationalpattern;

public class MACLogger {
    public void error(String msg){
        System.out.println("Error '" + msg + "' to console.");
    }
    public void warn(String msg){
        System.out.println("Warn '" + msg + "' to console.");
    }
    public void info(String msg){
        System.out.println("Info '" + msg + "' to console.");
    }
    public void debug(String msg){
        System.out.println("Debug '" + msg + "' to console.");
    }
}
