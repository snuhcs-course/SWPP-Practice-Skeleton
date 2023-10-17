package com.example.lab4application;

public class RollDiceUseCase {
    private final NumRollRepository numRollRepository;
    private final RollDiceUtils rollDiceUtils;
    private int firstDieValue = -1;
    private int secondDieValue = -1;
    private String primeNumbersSmallerThanProduct = "";

    public RollDiceUseCase(NumRollRepository numRollRepository, RollDiceUtils rollDiceUtils) {
        this.numRollRepository = numRollRepository;
        this.rollDiceUtils = rollDiceUtils;
    }

    public void rollDice() {
        firstDieValue = rollDiceUtils.getRandomDiceNumber();
        secondDieValue = rollDiceUtils.getRandomDiceNumber();
        primeNumbersSmallerThanProduct = rollDiceUtils.findPrimeNumbers(firstDieValue, secondDieValue);
        notifyRoll();
    }
    private void notifyRoll() {
        numRollRepository.incNumRoll();
    }
    public void notifyReset() {
        //// IMPLEMENT HERE ////

        ////////////////////////
    }
    public int getFirstDieValue() {return firstDieValue;}
    public int getSecondDieValue() {return secondDieValue;}
    public int getNumRoll() {return numRollRepository.getNumRoll();}
    public String getPrimeNumbers() {return primeNumbersSmallerThanProduct;}
}
