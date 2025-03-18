package com.inspire12.likelionbackend.module.cart.presentation.controller;

import com.inspire12.likelionbackend.module.cart.application.dto.ShoppingCartRequest;
import com.inspire12.likelionbackend.module.cart.application.service.ShoppingCartUseCase;
import com.inspire12.likelionbackend.module.cart.domain.ShoppingCart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartUseCase shoppingCartUseCase;

    @PostMapping("/add")
    public void add(@RequestBody ShoppingCartRequest request) {
        shoppingCartUseCase.add(request.customerId(), request.menuId());
    }

    @PutMapping("/minus")
    public void minus(@RequestBody ShoppingCartRequest request) {
        shoppingCartUseCase.minus(request.customerId(), request.menuId());
    }

    @DeleteMapping
    public void delete(@RequestBody ShoppingCartRequest request) {
        shoppingCartUseCase.delete(request.customerId(), request.menuId());
    }

    @GetMapping
    public ShoppingCart get(@RequestParam Long customerId) {
        return shoppingCartUseCase.findCart(customerId);
    }
}
