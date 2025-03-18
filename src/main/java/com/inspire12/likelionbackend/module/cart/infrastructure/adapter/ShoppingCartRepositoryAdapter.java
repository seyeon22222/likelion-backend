package com.inspire12.likelionbackend.module.cart.infrastructure.adapter;

import com.inspire12.likelionbackend.module.cart.domain.ShoppingCart;
import com.inspire12.likelionbackend.module.cart.domain.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {

    public static final String PREFIX_KEY = "order:shopping-cart::";

    @Override
    public Optional<ShoppingCart> findByCustomerId(final Long customerId) {
        return Optional.empty();
    }

    @Override
    public void save(final ShoppingCart cart) {

    }

    private String createKey(Long customerId) {
        return PREFIX_KEY + customerId;
    }
}
