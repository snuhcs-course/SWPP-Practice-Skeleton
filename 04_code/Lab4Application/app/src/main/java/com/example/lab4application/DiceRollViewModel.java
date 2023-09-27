package com.example.lab4application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiceRollViewModel extends ViewModel {
    private final MutableLiveData<DiceRollUiState> uiState =
            new MutableLiveData(new DiceRollUiState(-1, -1, -1));

    public LiveData<DiceRollUiState> getUiState() {
        return uiState;
    }

    public void setNumRoll(RollDiceUseCase rollDiceUseCase) {
        uiState.setValue(
                new DiceRollUiState(-1, -1, rollDiceUseCase.getNumRoll())
        );
    }

    public void getData(RollDiceUseCase rollDiceUseCase) {
        uiState.setValue(
                new DiceRollUiState(
                        rollDiceUseCase.getFirstDieValue(),
                        rollDiceUseCase.getSecondDieValue(),
                        // currently updates from previous UI
                        rollDiceUseCase.getNumRoll()
                )
        );
    }

    public void notifyRoll(RollDiceUseCase rollDieUseCase) {
        rollDieUseCase.rollDice();
    }

    public void notifyReset(RollDiceUseCase rollDieUseCase) {
        //// IMPLEMENT HERE ////

        ////////////////////////
    }
}
