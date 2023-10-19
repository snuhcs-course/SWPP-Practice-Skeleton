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
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExampleDiceRollViewModelTest {
    @Mock
    private RollDiceUseCase rollDiceUseCase;
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DiceRollViewModel viewModel;
    @Before
    public void setup() {
        viewModel = new DiceRollViewModel();
    }

    @Test
    public void setNumRollTest_step1() {
        // GIVEN a fresh use case (already mocked)

        // WHEN a use case is done
        viewModel.setNumRoll(rollDiceUseCase);

        // THEN UiState is changed but test fails at liveData
        DiceRollUiState result = viewModel.getUiState().getValue();
        assertNotNull(result);

        // Test fails if InstantTaskExecutorRule isn't set. Uncomment the rule above and try again.
    }

    @Test
    public void setNumRollTest_step2() {
        // GIVEN a fresh use case (already mocked)

        // WHEN a use case is done
        viewModel.setNumRoll(rollDiceUseCase);

        // THEN UiState is changed but test fails at liveData
        DiceRollUiState result = viewModel.getUiState().getValue();
        assertNotNull(result);
        assertEquals(50, (long)viewModel.getLiveData().getValue());

        // Test fails because LiveData isn't appropriately updated (no Observer). Add observer and try again.
    }

    @Test
    public void setNumRollTest_step3() {
        // GIVEN a fresh use case (already mocked)
        // Create observer - doesn't have to do anything!
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onChanged(Integer diceRollUiState) {
            }
        };

        try {
            // Observe the LiveData
            viewModel.getLiveData().observeForever(observer);

            // WHEN setNumRoll is called
            viewModel.setNumRoll(rollDiceUseCase);

            // THEN UiState is changed but test fails at liveData
            DiceRollUiState result = viewModel.getUiState().getValue();
            assertNotNull(result);
            assertEquals(0, (long)viewModel.getLiveData().getValue());

            // Test passes!
        }
        finally {
            // Don't forget to remove the observer!
            viewModel.getLiveData().removeObserver(observer);
        }
    }

    @Test
    public void setNumRollTest_step4() {
        // GIVEN a fresh use case (already mocked)
        // Create observer - doesn't have to do anything!
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onChanged(Integer diceRollUiState) {
            }
        };

        try {
            // Observe the LiveData
            viewModel.getLiveData().observeForever(observer);

            // WHEN setNumRoll is called
            viewModel.setNumRoll(rollDiceUseCase);

            // THEN UiState is changed but test fails at liveData
            DiceRollUiState result = viewModel.getUiState().getValue();
            assertNotNull(result);
            assertEquals(-1, result.getFirstDieValue());
            assertEquals(-1, result.getSecondDieValue());
            assertEquals(0, result.getNumRolls());
            assertEquals("[]", result.getPrimeNumbers());
            assertEquals(0, (long)viewModel.getLiveData().getValue());

            // Test passes! But we're only testing default values... Does our code still work for other values?
        }
        finally {
            // Don't forget to remove the observer!
            viewModel.getLiveData().removeObserver(observer);
        }
    }
    @Test
    public void setNumRollTest_step5() {
        // GIVEN a fresh use case
        int numRoll = 5;
        String primeNumbers = "[2, 3, 5]";
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

            // Test passes even for other values!

        } finally {
            // Don't forget to remove the observer!
            viewModel.getLiveData().removeObserver(observer);
        }
    }
}