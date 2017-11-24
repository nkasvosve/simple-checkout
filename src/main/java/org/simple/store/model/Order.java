package org.simple.store.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nickk
 */
public class Order {

    private List<OrderItem> orderItems = new ArrayList<>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return orderItems != null ? orderItems.equals(order.orderItems) : order.orderItems == null;

    }

    @Override
    public int hashCode() {
        return orderItems != null ? orderItems.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItems=" + orderItems +
                '}';
    }
}
