package com.apedano.ftgo.orderservice;

import com.apedano.ftgo.model.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.beans.PropertyEditorSupport;

public class OrderItemEditor extends PropertyEditorSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderItemEditor.class);

    @Override
    public String getAsText() {
        LOGGER.info("OrderItemEditor.setAsText() called");
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        LOGGER.info("OrderItemEditor.setAsText() called with input [{}]", text);
        OrderItem orderItem = new OrderItem();
        setValue(orderItem);
    }
}
