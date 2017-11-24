package org.simple.store.model;

import org.junit.Test;

import java.math.BigDecimal;

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

    @Test
    public void checkTotalWIthNoItems(){
        OrderItem orderItem = new OrderItem();
        orderItem.setCount(1);
        org.junit.Assert.assertEquals(BigDecimal.ZERO, orderItem.getTotal());
    }
}
