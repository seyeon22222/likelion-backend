package com.inspire12.likelionbackend.module.order.domain;

import com.inspire12.likelionbackend.module.cart.application.dto.ShoppingCartSnapshot;
import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {

    Order getOrderById(Long orderId);

    boolean checkOrderValid(ShoppingCartSnapshot shoppingCart, OrderRequest orderRequest);

    Order save(ShoppingCartSnapshot shoppingCart, OrderRequest orderRequest);

    Order getOrderByOrderNumber(String orderNumber);
}
