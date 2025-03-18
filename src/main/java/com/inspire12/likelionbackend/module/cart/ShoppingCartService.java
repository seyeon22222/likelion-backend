package com.inspire12.likelionbackend.module.cart;

import com.inspire12.likelionbackend.module.cart.application.dto.ShoppingCartSnapshot;

public interface ShoppingCartService {
    void clearCart();

    void order();

    //    void setStore(Commodity store);
    ShoppingCartSnapshot getItems(int customerId);
}
