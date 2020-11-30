package com.apedano.ftgo.orderservice;

import com.apedano.ftgo.model.Item;
import com.apedano.ftgo.model.Order;
import com.apedano.ftgo.model.OrderItem;
import com.apedano.ftgo.orderservice.persistence.OrderJpa;

import java.util.Arrays;
import java.util.List;

public class OrderDto extends OrderJpa {
    private List<OrderItem> allOrderItems = Arrays.asList(
            new OrderItem(Item.PIZZA),
            new OrderItem(Item.ROAST_BEEF)
    );

    public List<OrderItem> getAllOrderItems() {
        return allOrderItems;
    }

    public void setAllOrderItems(List<OrderItem> allOrderItems) {
        this.allOrderItems = allOrderItems;
    }
}
