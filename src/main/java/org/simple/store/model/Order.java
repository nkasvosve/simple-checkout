package org.simple.store.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nickk
 */
public class Order {

    private Set<OrderItem> orderItems = new HashSet<>();

    public Set<OrderItem> getOrderItems() {
        return Collections.unmodifiableSet(orderItems);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem orderItem : orderItems) {
            total = total.add(orderItem.getTotal());
        }
        return total;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void addOrderItem(OrderItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Null OrderItem found");
        }

        if (item.getProduct() == null) {
            throw new IllegalArgumentException("Null OrderItem product found");
        }

        if (item.getCount() < 0) {
            throw new IllegalArgumentException("Invalid OrderItem count found");
        }

        boolean found = false;
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct().equals(item.getProduct())) {
                int current = orderItem.getCount();
                int itemCount = item.getCount() + current;
                orderItem.setCount(itemCount);
                found = true;
            }
        }
        if (!found) {
            orderItems.add(item);
        }
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
                "\norderItems=" + orderItems +
                "\nTotal=>" + getTotal() +
                "}\n";
    }
}
