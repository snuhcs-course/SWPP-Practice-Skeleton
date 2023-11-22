package com.example.visitorexample;

class Computer implements ComputerPart {
    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[] {new CPU(), new GPU(), new RAM()};
    }

    @Override
    public void run() {
        for (int i = 0; i < parts.length; i++) {
            parts[i].run();
        }
        System.out.println("Running Computer");
    }
}
