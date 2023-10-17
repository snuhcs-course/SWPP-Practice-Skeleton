package com.example.lab4application;

import android.widget.Button;
import android.widget.TextView;

public class MainUI {
    private final TextView tv_firstDice;
    private final TextView tv_secondDice;
    private final TextView tv_numRolled;
    private final TextView tv_primeNumbers;

    private final Button bt_roll;

    public MainUI(TextView tv_firstDice,
                  TextView tv_secondDice,
                  TextView tv_numRolled,
                  TextView tv_primeNumbers,
                  Button bt_roll) {
        this.tv_firstDice = tv_firstDice;
        this.tv_secondDice = tv_secondDice;
        this.tv_numRolled = tv_numRolled;
        this.tv_primeNumbers = tv_primeNumbers;
        this.bt_roll = bt_roll;
    }

    public Button getRollButton() {
        return bt_roll;
    }
    public void updateUI(DiceRollUiState diceRollUiState) {
        _setInttoText(tv_firstDice, diceRollUiState.getFirstDieValue());
        _setInttoText(tv_secondDice, diceRollUiState.getSecondDieValue());
        _setInttoText(tv_numRolled, diceRollUiState.getNumRolls());
        tv_primeNumbers.setText(diceRollUiState.getPrimeNumbers());
    }

    private void _setInttoText(TextView textView, int i) {
        if (i < 0) { textView.setText(""); }
        else { textView.setText(String.valueOf(i)); }
    }
}
