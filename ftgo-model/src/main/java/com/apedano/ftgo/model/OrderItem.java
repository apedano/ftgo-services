package com.apedano.ftgo.model;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private Item item;
    private int quantity;
    protected Order order;

    public OrderItem() {
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
