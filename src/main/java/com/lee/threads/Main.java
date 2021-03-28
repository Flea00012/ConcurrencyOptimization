package com.lee.threads;

import javax.sound.midi.Soundbank;

import static com.lee.threads.ThreadColor.*;

public class Main {
    public static void main (String [] args){
        System.out.println(ANSI_PURPLE +"hi from main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Anotherthread==");
        anotherThread.start();


        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED+"hello from anonymous thread implementation of run()");

                try{
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED+ "anotherthread terminted or timed out, so im running again."+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I could not wait after all. I was interrupted.");
                }
            }
        } );
        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE+"hello again from the main thread");

    }
}
