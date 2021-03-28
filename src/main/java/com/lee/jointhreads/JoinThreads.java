package com.lee.jointhreads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinThreads {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNum = Arrays.asList(0L, 3435L, 35435L, 1323L
                , 3425L);

        List<FactorialThread> threads = new ArrayList<>();

        for (long inputNumber : inputNum) {
            threads.add(new FactorialThread(inputNumber));
        }
        
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join(2000);

        }

        for (int i = 0; i < inputNum.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("factorial of " + inputNum.get(i) + " is " + factorialThread.getResult());

            } else {
                System.out.println("the calculation for " + inputNum.get(i) + " is still in progress.");
            }
        }

    }
}

