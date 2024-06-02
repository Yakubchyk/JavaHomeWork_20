package com.yk2;

public class Consumer implements Runnable {

    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                store.customer();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
