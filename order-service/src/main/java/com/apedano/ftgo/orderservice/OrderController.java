package com.apedano.ftgo.orderservice;

import com.apedano.ftgo.model.*;
import com.apedano.ftgo.orderservice.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Value("${MY_VALUE}")
    private String myValue;

    @Autowired
    private OrderMessagingService orderMessagingService;

    @Autowired
    private OrderService orderService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(OrderItem.class,
                new OrderItemEditor());
    }

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

    @GetMapping("/create-order-form")
    public ModelAndView createOrderForm() {
        Order order = orderService.create();
        OrderDto orderDto = new OrderDto();
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("dto", orderDto);
        // sito web https://www.codejava.net/frameworks/spring-boot/spring-boot-form-handling-tutorial-with-spring-form-tags-and-jsp
        return new ModelAndView("createOrderForm", modelMap) ;
    }

    @GetMapping(value = "/order/{reference}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(
            @PathVariable("reference") String reference) {
        return orderService.loadByReference(reference);
    }


    @PostMapping("/save-order")
    public ModelAndView saveOrder(@ModelAttribute OrderDto dto, Model model) {
//        model.addAttribute("books", bookService.findAll());
//        return "redirect:/books/all";
        if(dto.getAllOrderItems().isEmpty()) {
            LOGGER.warn("No order items returned");
        }
        OrderJpa orderJpa = orderService.createFromDto(dto);
        orderService.save(orderJpa);
        return new ModelAndView("redirect:/order/" +orderJpa.getReference(), new HashMap<>());
    }

}
