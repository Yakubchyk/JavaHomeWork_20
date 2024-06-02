package com.yk2;

public class Producer implements Runnable {

    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                store.producieren();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
