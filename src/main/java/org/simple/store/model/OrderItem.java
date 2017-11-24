package org.simple.store.model;

import java.math.BigDecimal;

/**
 * @author nickk
 */
public class OrderItem {

    private Product product;
    private int count;

    public BigDecimal getTotal() {
        if(product == null || count <=0) {
            return BigDecimal.ZERO;
        }

        BigDecimal price = product.getPrice();
        BigDecimal discount;

        if(product.getProductType() == ProductType.APPLE){
            int freeApples = count/2;
            if(freeApples > 0){
                discount = price.multiply(new BigDecimal(freeApples)).setScale(2);
                BigDecimal total = price.multiply(new BigDecimal(count)).setScale(2);
                total = total. subtract(discount);
                return total;
            }
        }
        else if(product.getProductType() == ProductType.ORANGE){
            int multiples = count/3;
            if(multiples > 0){
                int remainder = count % 3;

                if(remainder > 0){
                    BigDecimal remainderTotal = price.multiply(new BigDecimal(remainder));
                    BigDecimal actual = price.multiply(new BigDecimal(2 * multiples))
                            .add(remainderTotal).setScale(2);
                    return actual;
                }
                BigDecimal actual = price.multiply(new BigDecimal(2 * multiples)).setScale(2);
                return actual;
            }
        }
        return price.multiply(new BigDecimal(count)).setScale(2);
    }

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
        return "\nOrderItem{" +
                "product=" + product +
                ", count=" + count +
                '}';
    }
}
