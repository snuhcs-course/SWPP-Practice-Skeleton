package com.example.observerexample;

import java.util.ArrayList;

public class Display {
    private int temperature;
    private int humidity;
    private int pressure;

    public void update(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity " + pressure + " pressure");
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }
}
