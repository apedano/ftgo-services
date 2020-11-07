package com.apedano.orderservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    /**
     * https://hackmd.io/@ryanjbaxter/spring-on-k8s-workshop
     * https://www.baeldung.com/spring-boot-docker-images
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/greetings")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        return "Hello, " + name;
    }


}
