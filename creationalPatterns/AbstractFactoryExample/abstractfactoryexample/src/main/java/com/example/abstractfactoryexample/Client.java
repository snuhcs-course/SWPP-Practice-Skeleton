package com.example.abstractfactoryexample;

import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        String company = "Apple";
        Phone phone;
        Tablet tablet;
        Laptop laptop;

        if(company.equals("Apple")){
            phone = new iPhone15();
            tablet = new iPad();
            laptop = new MacBook();
        } else {
            phone = new GalaxyS23();
            tablet = new GalaxyTab();
            laptop = new GalaxyBook();
        }

        phone.call();
        tablet.touch();
        laptop.typing();
    }
}