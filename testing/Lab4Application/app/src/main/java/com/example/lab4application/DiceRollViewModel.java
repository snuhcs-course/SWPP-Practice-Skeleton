package com.example.lab4application;

import static androidx.lifecycle.Transformations.map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiceRollViewModel extends ViewModel {
    private final MutableLiveData<DiceRollUiState> uiState =
            new MutableLiveData(new DiceRollUiState(-1, -1, -1, "hello"));

    // useless function to check the use case of LiveData Observer in testing
    public LiveData<Integer> liveData = map(uiState, data -> data.getNumRolls() * 10);
    public LiveData<Integer> getLiveData() { return liveData;}

    public LiveData<DiceRollUiState> getUiState() {
        return uiState;
    }

    public void setNumRoll(RollDiceUseCase rollDiceUseCase) {
        uiState.setValue(
                new DiceRollUiState(-1, -1, rollDiceUseCase.getNumRoll(), rollDiceUseCase.getPrimeNumbers())
        );
    }

    public void getData(RollDiceUseCase rollDiceUseCase) {
        uiState.setValue(
                new DiceRollUiState(
                        rollDiceUseCase.getFirstDieValue(),
                        rollDiceUseCase.getSecondDieValue(),
                        rollDiceUseCase.getNumRoll(),
                        rollDiceUseCase.getPrimeNumbers()
                )
        );
    }

    public void notifyRoll(RollDiceUseCase rollDieUseCase) {
        rollDieUseCase.rollDice();
    }

    public void notifyReset(RollDiceUseCase rollDieUseCase) {
        rollDieUseCase.notifyReset();
    }
}
