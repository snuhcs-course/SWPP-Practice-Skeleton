package com.example.lab4application;
public class NumRollRepository {
    private final NumRollDataSource numRollDataSource;

    public NumRollRepository(NumRollDataSource numRollDataSource) {
        this.numRollDataSource = numRollDataSource;
    }

    public int getNumRoll() {
        return numRollDataSource.getNumRoll();
    }
    public void incNumRoll() {
        numRollDataSource.storeNumRoll(numRollDataSource.getNumRoll() + 1);
    }
    public void resetNumRoll() {
        //// IMPLEMENT HERE ////

        ////////////////////////
    }
}
