package com.example.observerexample;

import java.util.Random;

public class WeatherData {
    private int temperature;
    private int humidity;
    private int pressure;

    public void setMeasurements() {
        Random random = new Random();
        this.temperature = random.nextInt(0, 100);
        this.humidity = random.nextInt(0, 100);
        this.pressure = random.nextInt(0, 100);
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
