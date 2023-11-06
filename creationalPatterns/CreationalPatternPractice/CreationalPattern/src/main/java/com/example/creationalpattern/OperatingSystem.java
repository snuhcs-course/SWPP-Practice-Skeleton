package com.example.creationalpattern;

public class OperatingSystem {
    private static String type = "MAC";
    public static void main(String[] args){
        adder();
        multiplier();
    }

    private static void adder(){
        String loggerType = "File";
        String message = "log from adder";

        if (loggerType.equals("MAC")){
            MACLogger logger = new MACLogger();
            logger.error(message);
        } else if (loggerType.equals("Android")){
            AndroidLogger logger = new AndroidLogger();
            logger.error(message);
        } else if (loggerType.equals("File")){
            FileLogger logger = new FileLogger();
            logger.error(message);
        } else if (loggerType.equals("Network")){
            NetworkLogger logger = new NetworkLogger();
            logger.error(message);
        }
    }

    private static void multiplier(){
        String loggerType = "Android";
        String message = "log from multiplier";

        if (loggerType.equals("Mac")){
            MACLogger logger = new MACLogger();
            logger.error(message);
        } else if (loggerType.equals("Android")){
            AndroidLogger logger = new AndroidLogger();
            logger.error(message);
        } else if (loggerType.equals("File")){
            FileLogger logger = new FileLogger();
            logger.error(message);
        } else if (loggerType.equals("Network")){
            NetworkLogger logger = new NetworkLogger();
            logger.error(message);
        }
    }
}