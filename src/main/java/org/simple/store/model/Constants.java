package org.simple.store.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final Map<ProductType, BigDecimal> PRICES = new HashMap<>();

    static{
        PRICES.put(ProductType.APPLE, new BigDecimal(".60").setScale(2));
        PRICES.put(ProductType.ORANGE, new BigDecimal(".25").setScale(2));
    }
}
