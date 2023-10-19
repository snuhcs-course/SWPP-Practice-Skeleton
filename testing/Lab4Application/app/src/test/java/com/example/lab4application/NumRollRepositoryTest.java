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
public class NumRollRepositoryTest {
    private  NumRollRepository numRollRepository;
    @Mock
    private NumRollDataSource numRollDataSource;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        numRollRepository = new NumRollRepository(numRollDataSource);
    }
    @Test
    public void getNumRoll_five_returnsFive() {
        // GIVEN fresh state
        int expected = 5;
        when(numRollDataSource.getNumRoll()).thenReturn(expected);

        // WHEN getNumRoll() called
        int result = numRollRepository.getNumRoll();

        // THEN numRollDataSource.getNumRoll() is called once and returns five (stubbed)
        verify(numRollDataSource).getNumRoll();
        assertEquals(expected, result);
    }

    @Test
    public void incNumRoll_five_storeNumRollCalledWithSix() {
        // GIVEN getNumRoll returns 5
        int input = 5;
        when(numRollDataSource.getNumRoll()).thenReturn(input);

        // WHEN incNumRoll() called
        numRollRepository.incNumRoll();

        // THEN numRollDataSource.storeNumRoll() is called once with 6 as input
        verify(numRollDataSource).storeNumRoll(input + 1);
    }

    @Test
    public void resetNumRoll_called_returnsZero() {
        // WHEN resetNumRoll() is called
        numRollRepository.resetNumRoll();

        // THEN
        verify(numRollDataSource).resetNumRoll();
    }
}