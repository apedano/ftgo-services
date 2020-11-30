package com.apedano.ftgo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Item implements Serializable {

    private static final String PIZZA_NAME = "PIZZA";
    private static final String PASTA_NAME = "PASTA";
    private static final String ROAST_BEEF_NAME = "ROAST_BEEF";
    private static final String DESSERT_NAME = "DESSERT";

    public static final Item PIZZA = new Item(PIZZA_NAME, BigDecimal.valueOf(0.8), BigDecimal.TEN);
    public static final Item PASTA = new Item(PASTA_NAME, BigDecimal.valueOf(0.4), BigDecimal.valueOf(18));
    public static final Item ROAST_BEEF = new Item(ROAST_BEEF_NAME, BigDecimal.valueOf(0.6), BigDecimal.valueOf(16));
    public static final Item DESSERT = new Item(DESSERT_NAME, BigDecimal.valueOf(0.35), BigDecimal.valueOf(7));

    protected static final Map<String, Item> ITEM_BY_NAME_MAP = new HashMap() {
        {
            put(PIZZA_NAME, PIZZA);
            put(PASTA_NAME, PASTA);
            put(ROAST_BEEF_NAME, ROAST_BEEF);
            put(DESSERT_NAME, DESSERT);
        }
    };

    private String name;
    private BigDecimal weight;
    private BigDecimal price;

    public Item() {
    }

    protected Item(String name, BigDecimal weight, BigDecimal price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static Item getByName(String name) {
        String nameUC = name.toUpperCase();
        return ITEM_BY_NAME_MAP.getOrDefault(nameUC, null);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
