package com.lee.threads;

public class MinMaxMetrics {

    // Add all necessary member variables

    private volatile long min;
    private volatile long max;


    /**
     * Initializes all member variables
     */
    public MinMaxMetrics() {
        // Add code here
        min = 0;
        max = 0;

    }

    /**
     * Adds a new sample to our metrics.
     */
    public void addSample(long newSample) {
        // Add code here
synchronized (this ){
    this.min = Math.min(newSample, this.min);
    this.max = Math.max(newSample,this.max);
}

    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        // Add code here
        return this.min;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        // Add code here
        return this.max;
    }
}

