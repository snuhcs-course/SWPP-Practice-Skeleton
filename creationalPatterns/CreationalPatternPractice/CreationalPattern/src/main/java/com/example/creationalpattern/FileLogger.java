package com.example.creationalpattern;

public class FileLogger {
    public void error(String msg){
        // In practical, the below line is implemented using file I/O
        System.out.println("Error '" + msg + "' to file.");
    }
    public void warn(String msg){
        System.out.println("Warn '" + msg + "' to file.");
    }
    public void info(String msg){
        System.out.println("Info '" + msg + "' to file.");
    }
    public void debug(String msg){
        System.out.println("Debug'" + msg + "' to file.");
    }
}
