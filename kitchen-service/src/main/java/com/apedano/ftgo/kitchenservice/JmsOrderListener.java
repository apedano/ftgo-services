package com.apedano.ftgo.kitchenservice;

import com.apedano.ftgo.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Unlike the pull model, where an explicit call to receive() or receiveAndConvert()
 * was required to receive a message, a message listener is a passive component that’s
 * idle until a message arrives.
 */
@Component
@Profile("listener")
public class JmsOrderListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsOrderListener.class);

    /**
     * Callback method for the listener when a message is received
     * @param order
     */
    @JmsListener(destination = "${send.order.queue.name}")
    public void receiveOrder(Order order) {
        LOGGER.info("JmsOrderListener: order received[{}]", order.toString());
    }

}
