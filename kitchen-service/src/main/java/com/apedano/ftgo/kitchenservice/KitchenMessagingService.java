package com.apedano.ftgo.kitchenservice;

import com.apedano.ftgo.model.Order;

interface KitchenMessagingService {

    void receive(Order order);
}
