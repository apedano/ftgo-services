package com.apedano.ftgo.orderservice.persistence;

import com.apedano.ftgo.model.Order;
import com.apedano.ftgo.model.OrderItem;
import com.apedano.ftgo.model.StatusEvent;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class OrderJpa extends Order {


    private long id;

    public OrderJpa() {
    }

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
    public String getReference() {
        return  super.getReference();
    }

    @Override
    @Column
    public LocalDateTime getCreationDate() {
        return super.getCreationDate();
    }

    @Override
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = OrderItemJpa.class)
    public Collection<OrderItem> getOrderItems() {
        return super.getOrderItems();
    }

    @Override
    //@ElementCollection(targetClass = Status.class) this cannot be used
//    @JoinTable(name = "tblInterests", joinColumns = @JoinColumn(name = "personID"))
//    @Column(name = "interest", nullable = false)
    @OneToMany(targetEntity = StatusEventJpa.class, cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<StatusEvent> getStatuseEvents() {
        return super.getStatuseEvents();
    }





}
