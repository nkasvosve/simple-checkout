package org.simple.store.model;

import org.junit.Test;

/**
 * @author nickk
 */
public class OrderTest {

    @Test(expected = IllegalArgumentException.class)
    public void showAddingNullOrderItemIsNotAllowed(){
        Order order = new Order();
        order.addOrderItem(null);
    }
}
