package com.apedano.ftgo.orderservice;

import com.apedano.ftgo.model.*;
import com.apedano.ftgo.orderservice.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.apedano.ftgo.model.Item.getByName;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderJpa loadByReference(String reference) {
        return orderRepository.findByReference(reference);
    }

    public OrderJpa create() {
        OrderJpa order = new OrderJpa();
        Item item = Item.PIZZA;
        ItemJpa itemJpa = new ItemJpa(item);
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

    @Transactional
    public void save(OrderJpa order) {
        orderRepository.save(order);
    }

    public OrderJpa createFromDto(OrderDto dto) {
        OrderJpa orderJpa = new OrderJpa();
        orderJpa.setReference(dto.getReference());
        orderJpa.setId(dto.getId());
        orderJpa.setCreationDate(LocalDateTime.now());
        orderJpa.setOrderItems(
        dto.getAllOrderItems().stream().map(orderItemDto -> {
            ItemJpa byName = new ItemJpa(getByName(orderItemDto.getItem().getName()));
            OrderItem orderItem = new OrderItemJpa();
                    orderItem.setItem(byName);
                    orderItem.setQuantity(orderItemDto.getQuantity());
                    orderItem.setOrder(orderJpa);
                    return orderItem;
                }).collect(Collectors.toList()));
        StatusEvent statusEvent = new StatusEventJpa();
        statusEvent.setEventDate(LocalDateTime.now());
        statusEvent.setIssuer("order-service");
        statusEvent.setStatus(Status.PENDING);
        return orderJpa;
    }
}
