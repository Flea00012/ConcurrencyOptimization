package com.lee.packaging;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

class PurchaseTest {
    Package aPackage;
    Purchase purchase;

    @BeforeAll
    public void before() {
        this.aPackage = new Package(1, "pants", "New York", "Stockholm", "John Park");
        this.purchase = new Purchase(10, aPackage);
    }

    @Test
    public void whenUserPurchases_thenReduceInventoryNumberByOne() {
        this.purchase.start();
        boolean emptyCheck = this.purchase.isCatalogEmpty();
        Assert.assertTrue(emptyCheck);
    }

}