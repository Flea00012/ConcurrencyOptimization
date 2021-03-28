package com.lee.threads;

import org.slf4j.LoggerFactory;
import java.util.logging.Logger;

import static com.lee.threads.ThreadColor.ANSI_RED;


public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "hello from MyRunnable thread");


        }
    }

