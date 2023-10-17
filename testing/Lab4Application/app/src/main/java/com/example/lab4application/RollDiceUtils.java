package com.example.lab4application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RollDiceUtils {
    public int getRandomDiceNumber(){
        return ThreadLocalRandom.current().nextInt(0, 6) + 1;
    }
    public String findPrimeNumbers(int A, int B){
        List<Integer> primes = new ArrayList<>();
        int product = A * B;
        for (int i = 2; i < product; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes.toString();
    }

    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        // Check for divisibility from 2 to sqrt(num)
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
