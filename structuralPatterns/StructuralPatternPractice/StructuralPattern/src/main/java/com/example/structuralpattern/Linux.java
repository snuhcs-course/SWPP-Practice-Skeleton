package com.example.structuralpattern;

public class Linux {
    public static void main(String[] args) {
        File file1 = new File("File 1");
        File file2 = new File("File 2");
        File file3 = new File("File 3");

        Directory directory1 = new Directory("Directory 1");
        Directory directory2 = new Directory("Directory 2");
        Directory directory3 = new Directory("Directory 3");

        directory1.add(file1);
        directory2.add(file2);
        directory3.add(file3);

        directory1.add(directory2);
        directory1.add(directory3);

        directory1.info("");
    }
}