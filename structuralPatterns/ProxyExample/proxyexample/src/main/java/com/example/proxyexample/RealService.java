package com.example.proxyexample;

public class RealService {
    public void execute(){
        System.out.println("Execution start");
        for(int i = 0; i < 10; i++){
            System.out.println(i * i);
        }
        System.out.println("Execution end");
    }
}
