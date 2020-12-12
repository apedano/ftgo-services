package com.apedano.ftgo.orderservice;

import com.apedano.ftgo.model.Order;

interface OrderMessagingService {

    void send(Order order);
}
