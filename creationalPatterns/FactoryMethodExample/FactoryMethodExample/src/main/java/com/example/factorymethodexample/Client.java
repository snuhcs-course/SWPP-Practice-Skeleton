package com.example.factorymethodexample;

public class Client {
    public static void main(String args[]){
        Phone s22 = new GalaxyS22();
        Phone s23 = new GalaxyS23();

        s22.info();
        s23.info();
    }
}