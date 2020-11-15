package com.apedano.ftgo.orderservice;

import com.apedano.ftgo.model.Item;
import com.apedano.ftgo.model.Order;
import com.apedano.ftgo.model.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Value("${MY_VALUE}")
    private String myValue;

    @Autowired
    OrderMessagingService orderMessagingService;


    /**
     * https://hackmd.io/@ryanjbaxter/spring-on-k8s-workshop
     * https://www.baeldung.com/spring-boot-docker-images
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/greetings")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        LOGGER.info("Value of myValue attribute: {}", myValue);
        LOGGER.info("Request received with name: {}", name);
        return "Hello, " + name;
    }

    @GetMapping("/create-order")
    public String greeting(Model model) {
        LOGGER.info("Create order request received");
        OrderItem twoPizzas = new OrderItem(Item.PIZZA, 2);
        Order order = new Order(twoPizzas);
        orderMessagingService.send(order);
        LOGGER.info("Order sent");
        return order.toString();
    }


}
