package com.apedano.ftgo.orderservice;

import com.apedano.ftgo.model.Order;
import com.apedano.ftgo.model.Status;
import com.apedano.ftgo.orderservice.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderJpa create() {
        OrderJpa order = new OrderJpa();
        ItemJpa itemJpa = new ItemJpa("pizza", BigDecimal.valueOf(15), BigDecimal.TEN);
        OrderItemJpa twoPizzas = new OrderItemJpa();
        twoPizzas.setQuantity(2);
        twoPizzas.setItem(itemJpa);
        twoPizzas.setOrder(order);
        order.setOrderItems(Collections.singleton(twoPizzas));
        StatusEventJpa statusEventJpa = new StatusEventJpa();
        statusEventJpa.setEventDate(LocalDateTime.now());
        statusEventJpa.setIssuer("order-service");
        statusEventJpa.setStatus(Status.PENDING);
        statusEventJpa.setOrder(order);
        order.add(statusEventJpa);
        return order;
    }

    public void save(OrderJpa order) {
        orderRepository.save(order);
    }

}
