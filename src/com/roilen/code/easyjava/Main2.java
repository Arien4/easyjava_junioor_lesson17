package com.roilen.code.easyjava;

public class Main2 {
    public static void main(String[] args) {
        Chest chest = new Chest(100);
        Player player1 = new Player("One");
        Player player2 = new Player("Two");
        Player player3 = new Player("Three");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                chest.withdraw(50, player1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                chest.withdraw(50, player2);
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                chest.withdraw(50, player3);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        chest.info();

    }
}
