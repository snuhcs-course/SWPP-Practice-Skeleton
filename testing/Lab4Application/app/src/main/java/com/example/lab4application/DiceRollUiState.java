package com.example.lab4application;

public class DiceRollUiState {
    private final int firstDieValue;
    private final int secondDieValue;
    private final int numRolls;
    private final String primeNumbers;

    public DiceRollUiState(int firstDieValue,
                           int secondDieValue,
                           int numRolls, String primeNumbers) {
        this.firstDieValue = firstDieValue;
        this.secondDieValue = secondDieValue;
        this.numRolls = numRolls;
        this.primeNumbers = primeNumbers;
    }

    public int getFirstDieValue() {return firstDieValue;}
    public int getSecondDieValue() {return secondDieValue;}
    public int getNumRolls() {return numRolls;}
    public String getPrimeNumbers() {return primeNumbers;}
}
