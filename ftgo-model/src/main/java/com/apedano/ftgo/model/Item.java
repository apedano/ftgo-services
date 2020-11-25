package com.apedano.ftgo.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {

    public static final Item PIZZA = new Item("PIZZA", BigDecimal.valueOf(0.8), BigDecimal.TEN);
    public static final Item PASTA = new Item("PASTA", BigDecimal.valueOf(0.4), BigDecimal.valueOf(18));
    public static final Item ROAST_BEEF = new Item("ROAST_BEEF", BigDecimal.valueOf(0.6), BigDecimal.valueOf(16));
    public static final Item DESSERT = new Item("DESSERT", BigDecimal.valueOf(0.35), BigDecimal.valueOf(7));

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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
