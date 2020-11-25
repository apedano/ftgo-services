package com.apedano.ftgo.orderservice.persistence;

import com.apedano.ftgo.model.Item;
import com.apedano.ftgo.model.Order;
import com.apedano.ftgo.model.OrderItem;

import javax.persistence.*;

@Entity
public class OrderItemJpa extends OrderItem {

    private long id;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderItemJpa() {
    }

    @Override
    @ManyToOne(targetEntity = ItemJpa.class, cascade = CascadeType.ALL)
    @JoinColumn(name="item_id", nullable=false)
    public Item getItem() {
        return super.getItem();
    }

    @Override
    @Column
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = OrderJpa.class)
    @JoinColumn(name="order_id", nullable=false) //owning part of the association
    public Order getOrder() {
        return super.getOrder();
    }
}
