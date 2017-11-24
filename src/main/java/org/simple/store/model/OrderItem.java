package org.simple.store.model;

/**
 * @author nickk
 */
public class OrderItem {

    private Product product;
    private int count;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isValid(){
        return count > -1 && product != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (count != orderItem.count) return false;
        return product != null ? product.equals(orderItem.product) : orderItem.product == null;

    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", count=" + count +
                '}';
    }
}
