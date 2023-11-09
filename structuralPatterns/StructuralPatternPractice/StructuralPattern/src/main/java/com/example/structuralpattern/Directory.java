package com.example.structuralpattern;

import java.util.ArrayList;

public class Directory {
    private String name;
    private ArrayList<Directory> directories;
    private ArrayList<File> files;
    public Directory(String name){
        this.name = name;
        this.directories = new ArrayList<Directory>();
        this.files = new ArrayList<File>();
    }
    public void add(File file){
        this.files.add(file);
    }
    public void add(Directory directory){
        this.directories.add(directory);
    }
    public void info(String prefix){
        System.out.println(prefix + this.name);
        for(File file: files)
            file.info(prefix + "\t");
        for(Directory directory: directories)
            directory.info(prefix + "\t");
    }
}
