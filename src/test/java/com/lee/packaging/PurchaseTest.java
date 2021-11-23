package com.lee.packaging;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PurchaseTest {

    Package aPackage;
    Purchase purchase;

    @Before
    public void setUp() throws Exception {
        this.aPackage = new Package(1, "pants", "New York", "Stockholm", "John Park");
        this.purchase = new Purchase(10, aPackage);
    }

    @Test
    public void whenUserPurchases_thenReduceInventoryNumberByOne() {
        this.purchase.start();
        boolean emptyCheck = this.purchase.isCatalogEmpty();

        int expected = this.purchase.getItemsRemaining();
//        Assert.assertFalse(emptyCheck);
    }
}
