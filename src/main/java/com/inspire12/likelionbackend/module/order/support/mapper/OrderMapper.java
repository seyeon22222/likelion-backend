package com.inspire12.likelionbackend.module.order.support.mapper;


import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;

public class OrderMapper {


    public static Order toInitDomain(OrderEntity orderEntity) {
        return new Order(orderEntity.getId()
                , orderEntity.getCustomerId()
                , orderEntity.getStoreId()
                , orderEntity.getOrderNumber()
                , orderEntity.getTotalAmount()
                , orderEntity.getStatus()
                , orderEntity.getCreatedAt());
    }

}
