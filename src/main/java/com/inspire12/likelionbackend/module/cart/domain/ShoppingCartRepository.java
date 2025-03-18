package com.inspire12.likelionbackend.module.cart.domain;

import java.util.Optional;

public interface ShoppingCartRepository {

    Optional<ShoppingCart> findByCustomerId(Long customerId);

    void save(ShoppingCart cart);
}
