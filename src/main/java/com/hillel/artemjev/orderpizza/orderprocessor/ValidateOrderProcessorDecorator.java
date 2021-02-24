package com.hillel.artemjev.orderpizza.orderprocessor;

import com.hillel.artemjev.orderpizza.entities.Order;
import com.hillel.artemjev.orderpizza.exception.InvalidOderDataException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidateOrderProcessorDecorator implements OrderProcessor {
    private OrderProcessor processor;

    @Override
    public void process(Order order) {
        if (order.getId() == null || order.getFrom() == null) {
            throw new InvalidOderDataException("Order data is not valid: " + order);
        }
        System.out.println("Order data is valid: " + order);
        processor.process(order);

    }
}
