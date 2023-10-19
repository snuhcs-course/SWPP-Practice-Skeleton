package com.example.lab4application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiceRollViewModelTest {
    private final RollDiceUseCase rollDiceUseCase = mock(RollDiceUseCase.class);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DiceRollViewModel viewModel;
    @Before
    public void setup() {
        viewModel = new DiceRollViewModel();
    }

    @Test
    public void setNumRollTest_notObserved_incorrect() {
        // GIVEN a fresh use case
        int numRoll = 5;
        String primeNumbers = "[2, 3, 5]";
        when(rollDiceUseCase.getNumRoll()).thenReturn(numRoll);
        when(rollDiceUseCase.getPrimeNumbers()).thenReturn(primeNumbers);

        // WHEN a use case is done
        viewModel.setNumRoll(rollDiceUseCase);

        // THEN UiState is changed but test fails at liveData
        DiceRollUiState result = viewModel.getUiState().getValue();
        assertNotNull(result);
        assertEquals(-1, result.getFirstDieValue());
        assertEquals(-1, result.getSecondDieValue());
        assertEquals(numRoll, result.getNumRolls());
        assertEquals(primeNumbers, result.getPrimeNumbers());
        assertEquals(50, (long)viewModel.getLiveData().getValue());
    }
    @Test
    public void setNumRollTest_observed_correct() {
        // GIVEN a fresh use case
        int numRoll = 5;
        String primeNumbers = "hello";
        when(rollDiceUseCase.getNumRoll()).thenReturn(numRoll);
        when(rollDiceUseCase.getPrimeNumbers()).thenReturn(primeNumbers);

        // WHEN a use case is done
        // Create observer - doesn't have to do anything!
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onChanged(Integer diceRollUiState) {
            }
        };

        try {
            // Observe the LiveData
            viewModel.getLiveData().observeForever(observer);
            // Call the function
            viewModel.setNumRoll(rollDiceUseCase);

            // THEN UiState is changed
            DiceRollUiState result = viewModel.getUiState().getValue();
            assertNotNull(result);
            assertEquals(-1, result.getFirstDieValue());
            assertEquals(-1, result.getSecondDieValue());
            assertEquals(numRoll, result.getNumRolls());
            assertEquals(primeNumbers, result.getPrimeNumbers());
            assertEquals(50, (long)viewModel.getLiveData().getValue());

        } finally {
            // Don't forget to remove the observer!
            viewModel.getLiveData().removeObserver(observer);
        }
    }

    @Test
    public void getData_useCase_checkUiStateChange() {
        // GIVEN a fresh use case
        int firstNumber = 2;
        int secondNumber = 4;
        int numRoll = 5;
        String primeNumbers = "[2, 3, 5, 7]";
        when(rollDiceUseCase.getFirstDieValue()).thenReturn(firstNumber);
        when(rollDiceUseCase.getSecondDieValue()).thenReturn(secondNumber);
        when(rollDiceUseCase.getNumRoll()).thenReturn(numRoll);
        when(rollDiceUseCase.getPrimeNumbers()).thenReturn(primeNumbers);

        // WHEN a use case is done
        // Create observer - doesn't have to do anything!
        Observer<DiceRollUiState> observer = new Observer<DiceRollUiState>() {
            @Override
            public void onChanged(DiceRollUiState diceRollUiState) {
            }
        };

        try {
            // Observe the LiveData
            viewModel.getUiState().observeForever(observer);
            // Call the function
            viewModel.getData(rollDiceUseCase);

            // THEN UiState is changed
            DiceRollUiState result = viewModel.getUiState().getValue();
            assertNotNull(result);
            assertEquals(firstNumber, result.getFirstDieValue());
            assertEquals(secondNumber, result.getSecondDieValue());
            assertEquals(numRoll, result.getNumRolls());
            assertEquals(primeNumbers, result.getPrimeNumbers());

        } finally {
            // Don't forget to remove the observer!
            viewModel.getUiState().removeObserver(observer);
        }
    }


    @Test
    public void notifyRoll_invokedOnce(){
        // GIVEN a use case (already mocked)
        // WHEN notifyRoll is invoked
        viewModel.notifyRoll(rollDiceUseCase);
        // THEN check that rollDiceUseCase.rollDice() was invoked once
        verify(rollDiceUseCase).rollDice();
    }

    @Test
    public void notifyReset_invokedOnce(){
        // GIVEN a use case (already mocked)
        // WHEN notifyRoll is invoked
        viewModel.notifyReset(rollDiceUseCase);
        // THEN check that rollDiceUseCase.rollDice() was invoked once
        verify(rollDiceUseCase).notifyReset();
    }
}