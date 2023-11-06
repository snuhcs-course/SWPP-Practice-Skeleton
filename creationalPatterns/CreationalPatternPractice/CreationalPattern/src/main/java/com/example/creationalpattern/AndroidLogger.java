package com.example.creationalpattern;

public class AndroidLogger {
    public void error(String msg){
        // In practical, the below line is implemented using Toast or other logging tools
        System.out.println("Error '" + msg + "' to Toast.");
    }
    public void warn(String msg){
        System.out.println("Warn '" + msg + "' to Toast.");
    }
    public void info(String msg){
        System.out.println("Info '" + msg + "' to Toast.");
    }
    public void debug(String msg){
        System.out.println("Debug '" + msg + "' to Toast.");
    }
}
