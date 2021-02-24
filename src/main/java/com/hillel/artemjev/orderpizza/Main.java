package com.hillel.artemjev.orderpizza;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hillel.artemjev.orderpizza.entities.Order;
import com.hillel.artemjev.orderpizza.orderprocessor.MessageOrderProcessor;
import com.hillel.artemjev.orderpizza.orderprocessor.OrderProcessor;
import com.hillel.artemjev.orderpizza.orderprocessor.SaveOrderProcessorDecorator;
import com.hillel.artemjev.orderpizza.orderprocessor.ValidateOrderProcessorDecorator;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.setId(1);
        order.setFrom("me");
        order.setText("hurry up");

        OrderProcessor orderProcessor = new MessageOrderProcessor();
        orderProcessor = new SaveOrderProcessorDecorator(orderProcessor, "orderpizza.txt", new ObjectMapper());
        orderProcessor = new ValidateOrderProcessorDecorator(orderProcessor);
        orderProcessor.process(order);

    }
}
