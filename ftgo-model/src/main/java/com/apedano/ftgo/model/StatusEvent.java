package com.apedano.ftgo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StatusEvent {

    private Status status;
    private LocalDateTime eventDate;
    private Order order;
    private String issuer;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Override
    public String toString() {
        return "StatusEvent{" +
                "status=" + status +
                ", eventDate=" + eventDate +
                ", order=" + order.getReference() +
                ", issuer='" + issuer + '\'' +
                '}';
    }
}
