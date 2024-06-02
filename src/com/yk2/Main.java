package com.yk2;

public class Main {
    public static void main(String[] args) {

        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        threadConsumer.start();
        threadProducer.start();

        try {
            threadConsumer.join();
            threadProducer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



/*
Задача *:
Имеются сущности Магазин, Производитель, Покупатель. Цель задачи сделать так чтобы
производитель произвел 5 единиц продукта, а покупатель их купил. Пока производитель
не произвел продукт, покупатель не может его купить. При этом одновременно в магазине
может находиться не более 3 товаров
 */


