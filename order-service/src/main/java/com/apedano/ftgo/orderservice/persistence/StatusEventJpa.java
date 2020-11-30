package com.apedano.ftgo.orderservice.persistence;

import com.apedano.ftgo.model.Order;
import com.apedano.ftgo.model.Status;
import com.apedano.ftgo.model.StatusEvent;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class StatusEventJpa extends StatusEvent {

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
    //@ElementCollection(targetClass = Status.class)
    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return super.getStatus();
    }

    @Override
    @Column
    public LocalDateTime getEventDate() {
        return super.getEventDate();
    }

    @Override
    @ManyToOne(targetEntity = OrderJpa.class)
    @JoinColumn(name="order_id", nullable=false)
    @JsonIgnore
    public Order getOrder() {
        return super.getOrder();
    }

    @Override
    public String getIssuer() {
        return super.getIssuer();
    }
}
