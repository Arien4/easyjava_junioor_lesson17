package com.roilen.code.easyjava;

public class TestVolatile extends Thread{
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        long counter = 0;
        while (keepRunning) {
            counter++;
        }
        System.out.println("Thread terminated " + counter);
    }

    public static void main(String[] args) {
        TestVolatile tv = new TestVolatile();
        tv.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main stopped sleeping");
        tv.keepRunning = false;
        try {
            tv.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("keepRunning set to " + tv.keepRunning);
    }
}
