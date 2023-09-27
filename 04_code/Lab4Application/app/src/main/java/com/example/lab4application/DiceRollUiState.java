package com.example.lab4application;

public class DiceRollUiState {
    private final int firstDieValue;
    private final int secondDieValue;
    private final int numRolls;

    public DiceRollUiState(int firstDieValue,
                           int secondDieValue,
                           int numRolls) {
        this.firstDieValue = firstDieValue;
        this.secondDieValue = secondDieValue;
        this.numRolls = numRolls;
    }

    public int getFirstDieValue() {return firstDieValue;}
    public int getSecondDieValue() {return secondDieValue;}
    public int getNumRolls() {return numRolls;}
}
