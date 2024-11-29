package com.diniig.samples.monitor;

public class Store {
    private int product = 0;

    public synchronized void put() {
        while (product >= 3) {
            try {
                System.out.println("Производитель ждет");
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();

    }

    public synchronized void get() {
        while (product < 1) {
            System.out.println("Покупатель пауза");
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
            }
            try {
                System.out.println("Покупатель ждет");
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

}
