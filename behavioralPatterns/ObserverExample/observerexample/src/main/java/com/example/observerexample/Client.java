package com.example.observerexample;

public class Client {
    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        Display display1 = new Display();
        Display display2 = new Display();

        weatherData.setMeasurements();

        if(weatherData.getTemperature() != display1.getTemperature()){
            if(weatherData.getHumidity() != display1.getHumidity()){
                if(weatherData.getPressure() != display1.getPressure()){
                    display1.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
                }
            }
        }

        if(weatherData.getTemperature() != display2.getTemperature()){
            if(weatherData.getHumidity() != display2.getHumidity()){
                if(weatherData.getPressure() != display2.getPressure()){
                    display2.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
                }
            }
        }
        // Do this everytime
    }
}