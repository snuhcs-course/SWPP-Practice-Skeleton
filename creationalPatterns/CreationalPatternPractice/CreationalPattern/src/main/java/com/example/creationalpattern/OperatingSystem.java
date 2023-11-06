package com.example.creationalpattern;

public class OperatingSystem {
    private static String type = "MAC";
    public static void main(String[] args){

        String currentOperatingSystem = getType();
        String message = "Log message";

        if (currentOperatingSystem.equals("MAC")){
            MACLogger logger = new MACLogger();
            logger.error(message);
        } else if (currentOperatingSystem.equals("Android")){
            AndroidLogger logger = new AndroidLogger();
            logger.error(message);
        } else if (currentOperatingSystem.equals("File")){
            FileLogger logger = new FileLogger();
            logger.error(message);
        } else if (currentOperatingSystem.equals("Network")){
            NetworkLogger logger = new NetworkLogger();
            logger.error(message);
        }
    }

    public static String getType(){
        return type;
    }
}