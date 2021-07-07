package com.lee.packaging;

public class Purchase extends Thread {

    private volatile int itemsRemaining;
    private Package aPackage;
    private volatile boolean isEmpty;

    public Purchase(int i, Package aPackage) {
        if (i > 0) {
            isEmpty = false;
        }
        this.itemsRemaining = i;
        this.aPackage = aPackage;
    }

    @Override
    public void start() {
        while (itemsRemaining > 0) {
            System.out.println("You bought a " + this.aPackage.getName());
            itemsRemaining--;
        }
    }

    public boolean isCatalogEmpty() {
        if (itemsRemaining != 0) {
            isEmpty = true;
        }
        return this.isEmpty;
    }

    public static void main(String[] args) {

        Package aPackage = new Package(1, "pants", "New York", "Stockholm", "John Park");
        Purchase purchase = new Purchase(10, aPackage);
        purchase.start();

    }
}
