package com.apedano.ftgo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Order implements Serializable {

    private String reference;
    private LocalDateTime creationDate;
    private Collection<OrderItem> orderItems;
    private Collection<StatusEvent> statuseEvents = new LinkedList<>();

    public Order() {
        this.reference = UUID.randomUUID().toString();
        this.creationDate = LocalDateTime.now();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Collection<StatusEvent> getStatuseEvents() {
        return statuseEvents;
    }

    public void add(StatusEvent statusEvent) {
        this.statuseEvents.add(statusEvent);
    }

    public String getReference() {
        return  this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setStatuseEvents(Collection<StatusEvent> statuseEvents) {
        this.statuseEvents = statuseEvents;
    }

    @Override
    public String toString() {
        return "Order{" +
                "reference='" + reference + '\'' +
                ", creationDate=" + creationDate +
                ", orderItems=" + orderItems +
                ", statuseEvents=" + statuseEvents +
                '}';
    }
}
