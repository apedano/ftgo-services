//package com.apedano.orderservice;
//
//import jdk.nashorn.internal.ir.annotations.Ignore;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest
//@Ignore
//public class WebLayerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @Ignore
//    public void shouldReturnDefaultMessage() throws Exception {
//        this.mockMvc.perform(get("/greetings")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello, World")));
//    }
//
//    @Test
//    @Ignore
//    public void shouldReturnNametMessage() throws Exception {
//        this.mockMvc.perform(get("/greetings?name=ale")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(equalToCompressingWhiteSpace("Hello, ale")));
//    }
//}