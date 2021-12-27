package com.roilen.code.easyjava;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count = new AtomicInteger();

    public Counter() {
        this.count.set(0);
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void inc() {
        this.count.incrementAndGet();
    }

    public void dec() {
        this.count.decrementAndGet();
    }
}
