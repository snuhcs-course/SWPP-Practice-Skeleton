package com.example.builderexample;

public class Client {
    public static void main(String[] args){
        ModelTrainer trainer = new ModelTrainer("Yolov5",
                "TrainDataloader", "TestDataloader",
                "SGD", "MSE",
                0.001, 64, 256);
        trainer.info();
    }
}