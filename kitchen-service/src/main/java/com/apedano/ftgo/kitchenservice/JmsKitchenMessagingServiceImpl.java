package com.apedano.ftgo.kitchenservice;

import com.apedano.ftgo.model.Order;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;

public class JmsKitchenMessagingServiceImpl implements KitchenMessagingService {

    @Autowired
    private JmsTemplate jmaJmsTemplate;

    private final ActiveMQQueue activeMQQueue;

    /**
     * The destination is the name of the queue/topic pointed from the properties
     * spring.artemis.mode=native
     * spring.artemis.host=localhost
     * spring.artemis.port=61616
     * spring.artemis.user=myuser
     * spring.artemis.password=mypassword
     * spring.activemq.in-memory=false
     * @param destination
     */
    @Autowired
    public JmsKitchenMessagingServiceImpl(@Value("${send.order.queue.name}") String destination) {
        this.activeMQQueue = new ActiveMQQueue(destination);

    }

    @Override
    public void receive(Order order) {

    }
}
