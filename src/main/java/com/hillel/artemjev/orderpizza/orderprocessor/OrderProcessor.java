package com.hillel.artemjev.orderpizza.orderprocessor;

import com.hillel.artemjev.orderpizza.entities.Order;

public interface OrderProcessor {
    void process(Order order);
}
