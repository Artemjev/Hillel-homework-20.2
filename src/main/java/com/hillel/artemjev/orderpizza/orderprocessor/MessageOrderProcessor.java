package com.hillel.artemjev.orderpizza.orderprocessor;

import com.hillel.artemjev.orderpizza.entities.Order;

public class MessageOrderProcessor implements OrderProcessor {
    @Override
    public void process(Order order) {
        System.out.println("pizza " + order + " accepted successfully");
    }
}
