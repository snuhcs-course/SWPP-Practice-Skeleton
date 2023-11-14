package com.example.builderexample;

public class ModelTrainer {
    String model;
    String trainDataloader;
    String validDataloader;
    String testDataloader;
    String optimizer;
    String lossFunction;
    double learningRate;
    String preProcessor;
    String postProcessor;
    String visualizer;
    int batchSize;
    int inputSize;

    public ModelTrainer(String model, String trainDataloader, String testDataloader, String optimizer, String lossFunction, double learningRate, int batchSize, int inputSize){
        this.model = model;
        this.trainDataloader = trainDataloader;
        this.testDataloader = testDataloader;
        this.optimizer = optimizer;
        this.lossFunction = lossFunction;
        this.learningRate = learningRate;
        this.batchSize = batchSize;
        this.inputSize = inputSize;
    }

    public ModelTrainer(String model, String trainDataloader, String validDataloader, String testDataloader, String optimizer, String lossFunction, double learningRate, int batchSize, int inputSize){
        this.model = model;
        this.trainDataloader = trainDataloader;
        this.validDataloader = validDataloader;
        this.testDataloader = testDataloader;
        this.optimizer = optimizer;
        this.lossFunction = lossFunction;
        this.learningRate = learningRate;
        this.batchSize = batchSize;
        this.inputSize = inputSize;
    }

    public void info(){
        System.out.println("Model: " + model);
        System.out.println("Train DataLoader: " + trainDataloader);
        System.out.println("Valid DataLoader: " + validDataloader);
        System.out.println("Test DataLoader: " + testDataloader);
        System.out.println("Optimizer: " + optimizer);
        System.out.println("Loss Function: " + lossFunction);
        System.out.println("Learning Rate: " + learningRate);
        System.out.println("Pre Processor: " + preProcessor);
        System.out.println("Post Processor: " + postProcessor);
        System.out.println("Visualizer: " + visualizer);
        System.out.println("Batch Size: " + batchSize);
        System.out.println("Input Size: " + inputSize);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTrainDataloader(String trainDataloader) {
        this.trainDataloader = trainDataloader;
    }

    public void setValidDataloader(String validDataloader) {
        this.validDataloader = validDataloader;
    }

    public void setTestDataloader(String testDataloader) {
        this.testDataloader = testDataloader;
    }

    public void setOptimizer(String optimizer) {
        this.optimizer = optimizer;
    }

    public void setLossFunction(String lossFunction) {
        this.lossFunction = lossFunction;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public void setPreProcessor(String preProcessor) {
        this.preProcessor = preProcessor;
    }

    public void setPostProcessor(String postProcessor) {
        this.postProcessor = postProcessor;
    }

    public void setVisualizer(String visualizer) {
        this.visualizer = visualizer;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public void setInputSize(int inputSize) {
        this.inputSize = inputSize;
    }
}


