package com.roilen.code.easyjava;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileCounter {
    private volatile int count;

    public VolatileCounter() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void inc() {
        this.count++;
    }

    public void dec() {
        this.count--;
    }
}
