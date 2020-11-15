package com.apedano.ftgo.kitchenservice;

import com.apedano.ftgo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * JmsTemplate offers several methods for receiving messages, but all of them use a
 * pull model. You call one of those methods to request a message, and the thread blocks
 * until a message is available (which could be immediately or it might take a while).
 */
@Service
public class JmsOrderPuller {

    @Value("${send.order.queue.name}")
    private String destination;

    @Autowired
    private JmsTemplate jms;

    public Order receiveOrder() {
        return (Order) jms.receiveAndConvert(destination);
    }
}
