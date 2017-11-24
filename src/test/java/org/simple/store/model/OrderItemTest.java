package org.simple.store.model;

import org.junit.Test;

/**
 * @author nickk
 */
public class OrderItemTest {

    @Test
    public void checkOrderItemValidityWithNoProduct(){
        OrderItem orderItem = new OrderItem();
        orderItem.setCount(1);

        org.junit.Assert.assertFalse(orderItem.isValid());
    }

    @Test
    public void checkOrderItemValidityWithAProduct(){
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        orderItem.setProduct(product);
        orderItem.setCount(1);

        org.junit.Assert.assertTrue(orderItem.isValid());
    }
}
