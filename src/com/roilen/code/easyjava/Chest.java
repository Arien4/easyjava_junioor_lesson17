package com.roilen.code.easyjava;

public class Chest {
    private int money = 0;

    public Chest(int money) {
        this.money = money;
    }

    public synchronized void withdraw(int amount, Player player) {
        if (this.money >= amount) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= amount;
            System.out.println("Withdrawn " + amount + " by player " + player.getName());
        } else {
            System.out.println("player " + player.getName() +" can't withdraw money. No enough gold!");
        }
    }

    public void info() {
        System.out.println("Gold: " + this.money);
    }
}
