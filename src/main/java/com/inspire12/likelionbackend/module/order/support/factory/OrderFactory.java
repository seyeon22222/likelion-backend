package com.inspire12.likelionbackend.module.order.support.factory;


import com.inspire12.likelionbackend.module.cart.application.dto.ShoppingCartSnapshot;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.DeliveryStatus;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderStatus;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderType;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderFactory {

    public static OrderEntity createEntityInitBeforeDelivery(ShoppingCartSnapshot shoppingCart, long customer, long storeId, UUID orderNumber, OrderType orderType) {
        return new OrderEntity(null,
                customer,
                shoppingCart.storeId(),
                shoppingCart.storeAmount(),// Total price
                orderType,
                shoppingCart.storeAmount(),
                0L,
                OrderStatus.PENDING_PAYMENT,
                DeliveryStatus.BEFORE_PAYMENT,
                orderNumber,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }


}
