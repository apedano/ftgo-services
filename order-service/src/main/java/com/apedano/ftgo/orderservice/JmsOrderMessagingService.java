package com.apedano.ftgo.orderservice;

import com.apedano.ftgo.model.Order;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderMessagingService implements OrderMessagingService {

    /**
     * With a JMS starter dependency (either Artemis or ActiveMQ) in your build, Spring
     * Boot will autoconfigure a JmsTemplate (among other things) that you can inject and
     * use to send and receive messages.
     * JmsTemplate is the centerpiece of Spring’s JMS integration support. Much like
     * Spring’s other template-oriented components, JmsTemplate eliminates a lot of
     * boilerplate code that would otherwise be required to work with JMS. Without JmsTemplate,
     * you’d need to write code to create a connection and session with the message broker, and more code
     * to deal with any exceptions that might be thrown in the course of sending a message.
     */
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
    public JmsOrderMessagingService(@Value("${send.order.queue.name}") String destination) {
        this.activeMQQueue = new ActiveMQQueue(destination);

    }

    /**
     * We can also use the {@link JmsTemplate#convertAndSend(String, Object)} method using a MessageConverter
     * implementation to transform the incoming object into the Jms message.
     * We can implement a custom MessageConverter
     * @Bean
     * public MappingJackson2MessageConverter messageConverter() {
     *  MappingJackson2MessageConverter messageConverter =
     *  new MappingJackson2MessageConverter();
     *  messageConverter.setTypeIdPropertyName("_typeId");
     *  return messageConverter;
     * }
     * @param order
     */
    @Override
    public void send(Order order) {
        jmaJmsTemplate.send(this.activeMQQueue, session ->
                session.createObjectMessage(order));
    }
}
