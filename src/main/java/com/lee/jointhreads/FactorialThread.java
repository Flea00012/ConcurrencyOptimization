package com.lee.jointhreads;

import java.math.BigInteger;

public class FactorialThread extends Thread {


    private long inputNum;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished = false;


    public FactorialThread(long inputNum) {
        this.inputNum = inputNum;
    }


    @Override
    public void run() {
        this.result = factorial(inputNum);
    }


    public BigInteger factorial(long n) {
        BigInteger tempResult = BigInteger.ONE;

        for (long i = n; i > 0; i--) {
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));

        }
        return tempResult;
    }

    public boolean isFinished() {
        return isFinished;

    }

    public BigInteger getResult() {
        return result;
    }
}

