package com.example.proxyexample;

public class Client {
    public static void main(String[] args){
        RealService realService = new RealService();
        realService.execute();
    }
}