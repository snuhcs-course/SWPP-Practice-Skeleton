package com.example.lab4application;

import java.util.concurrent.ThreadLocalRandom;

public class RollDiceUseCase {
    private final NumRollRepository numRollRepository;
    private int firstDieValue = -1;
    private int secondDieValue = -1;

    public RollDiceUseCase(NumRollRepository numRollRepository) {
        this.numRollRepository = numRollRepository;
    }

    public void rollDice() {
        firstDieValue = ThreadLocalRandom.current().nextInt(0, 6) + 1;
        secondDieValue = ThreadLocalRandom.current().nextInt(0, 6) + 1;
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
}
