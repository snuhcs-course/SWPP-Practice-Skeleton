package com.example.lab4application;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RollDiceUseCaseTest {
    private RollDiceUseCase rollDiceUseCase;

    @Mock
    private NumRollRepository numRollRepository;
    @Mock
    private RollDiceUtils rollDiceUtils;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        rollDiceUseCase = new RollDiceUseCase(numRollRepository, rollDiceUtils);
    }
    @Test
    public void rollDice_threeSix_sixPrimeNumbers() {
        // GIVEN empty slate
        int firstVal = 3;
        int secVal = 6;
        String primeNumbers = "[2, 3, 5, 7, 13, 17]";
        when(rollDiceUtils.getRandomDiceNumber()).thenReturn(firstVal).thenReturn(secVal);
        when(rollDiceUtils.findPrimeNumbers(firstVal, secVal)).thenReturn(primeNumbers);

        // WHEN rollDice() called
        rollDiceUseCase.rollDice();

        // THEN
        assertEquals(firstVal, rollDiceUseCase.getFirstDieValue());
        assertEquals(secVal, rollDiceUseCase.getSecondDieValue());
        assertEquals(primeNumbers, rollDiceUseCase.getPrimeNumbers());
    }

    @Test
    public void getNumRoll_checkNumRollRepositoryFunctionCalled() {
        rollDiceUseCase.getNumRoll();

        verify(numRollRepository).getNumRoll();
    }


}