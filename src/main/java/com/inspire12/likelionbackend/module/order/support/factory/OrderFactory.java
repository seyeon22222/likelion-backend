package com.inspire12.likelionbackend.module.order.support.factory;


import com.inspire12.likelionbackend.module.order.domain.Order;

public class OrderFactory {

    public static Order create() {
        return new Order();
    }
}
