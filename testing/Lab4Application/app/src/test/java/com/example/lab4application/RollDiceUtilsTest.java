package com.example.lab4application;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RollDiceUtilsTest {
    private RollDiceUtils rollDiceUtils;

    @Before
    public void setup(){
        rollDiceUtils = new RollDiceUtils();
    }
    @Test
    public void findPrimeNumbers_fiveSix_returnsPrimes() {
        // GIVEN input 5, 6
        int a = 5;
        int b = 6;

        // WHEN findPrimeNumbersSmallerThanProduct is called
        String result = rollDiceUtils.findPrimeNumbers(a,b);

        // THEN return [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]

    }

    @Test
    public void isPrime_one_returnsFalse() {
        // GIVEN input 1
        int input = 1;

        // WHEN isPrime is called
        boolean result = rollDiceUtils.isPrime(input);

        // THEN return false
        assertFalse(result);
    }

    @Test
    public void isPrime_two_returnsTrue() {
        // GIVEN input 2
        int input = 2;

        // WHEN isPrime is called
        boolean result = rollDiceUtils.isPrime(input);

        // THEN return true
        assertTrue(result);
    }
}