package com.apedano.ftgo.orderservice;

import com.apedano.ftgo.model.*;
import com.apedano.ftgo.orderservice.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@RestController
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Value("${MY_VALUE}")
    private String myValue;

    @Autowired
    private OrderMessagingService orderMessagingService;



    @Autowired
    private OrderService orderService;


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
        OrderJpa orderJpa = orderService.create();
        LOGGER.debug("Order created");
        orderService.save(orderJpa);
        LOGGER.debug("Order persisted");
//        orderMessagingService.send(orderJpa);
        LOGGER.debug("Order sent");
        return orderJpa.toString();
    }


}
