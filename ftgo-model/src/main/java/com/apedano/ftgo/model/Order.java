package com.apedano.ftgo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

public class Order implements Serializable {

    private String orderId;
    private LocalDateTime creationDate;
    private Collection<OrderItem> orderItems;
    private Collection<Status> statuses;

    public Order(OrderItem... orderItems) {
        this.orderId = UUID.randomUUID().toString();
        this.creationDate = LocalDateTime.now();
        this.orderItems = Arrays.asList(orderItems);
        this.statuses = Collections.singleton(Status.PENDING);
    }

    public void setStatuses(Status... statuses) {
        this.statuses = Arrays.asList(statuses);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", creationDate=" + creationDate +
                ", orderItems=" + orderItems.stream().map(OrderItem::toString).collect(Collectors.toList()) +
                ", statuses=" + statuses +
                '}';
    }
}
