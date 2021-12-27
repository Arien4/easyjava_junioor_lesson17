package com.roilen.code.easyjava;

public class VolatileTest {
    private volatile static int MY_INT = 0;

    public static void main(String[] args) {
        ChangeMaker cm = new ChangeMaker();
        cm.start();
        ChangeListener cl = new ChangeListener();
        cl.start();
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            while (MY_INT < 5) {
                System.out.println("Incrementing MY_INT " + ++MY_INT);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ChangeListener extends Thread {
        int localVar = MY_INT;

        @Override
        public void run() {
            while (MY_INT < 5) {
                if (localVar != MY_INT) {
                    System.out.println("Got change MY_INT " + MY_INT);
                    localVar = MY_INT;
                }
            }
        }
    }
}
