package com.lee.blockingqueues;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Runnable producer = () -> {

            int i = 0;

            boolean terminate = false;
            while (true) {

                try {
                    lock1.lock();
                    arrayBlockingQueue.put(++i);
                    System.out.println("added: " + i);
                    TimeUnit.MILLISECONDS.sleep(1000);
                    lock1.unlock();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        };


        Runnable consumer = () -> {
            while (true) {
                try {
                    lock2.lock();
                    Integer poll;
                    poll = arrayBlockingQueue.take();
                    System.out.println("Polled: " + poll);
                    TimeUnit.MILLISECONDS.sleep(1000);

                    lock2.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.shutdownNow();
    }


}



