package com.yk2;

public class Store {

    private int MAX_CAPACITY = 500 ;
    private int product = 0;

    public synchronized void producieren() throws InterruptedException {
        while (product >= MAX_CAPACITY) {
            wait();
        }
        product++;
        System.out.println("Производитель произвел 1 продукт. " +
                "В магазине сейчас: " + product + " шт." );
        notify();
    }

    public synchronized void customer() throws InterruptedException {
        while (product < 1) {
            wait();
        }
        product--;
        System.out.println("Покупатель купил 1 продукт. " +
                "В магазине сейчас " + product + " шт.");
        notify();
    }
}
