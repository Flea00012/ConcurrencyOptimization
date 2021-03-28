package com.lee.threads;

import static com.lee.threads.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "hey from " + currentThread().getName());

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println(ANSI_BLUE + "another thread woke me up.");
            return;
        }
        System.out.println(ANSI_BLUE+"3 seconds have passed and " + Thread.currentThread().getName() + " is awake again.");

    }
}
