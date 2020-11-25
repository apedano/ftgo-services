package com.apedano.ftgo.orderservice.persistence;

import com.apedano.ftgo.model.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ItemJpa extends Item {

    public ItemJpa(String name, BigDecimal weight, BigDecimal price) {
        super(name, weight, price);
    }

    public ItemJpa() {
    }

    private long id;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    @Column
    public String getName() {
        return super.getName();
    }

    @Override
    @Column
    public BigDecimal getWeight() {
        return super.getWeight();
    }

    @Override
    @Column
    public BigDecimal getPrice() {
        return super.getPrice();
    }

}
