package com.inspire12.likelionbackend.module.cart.domain;

import java.util.List;
import java.util.Optional;

public interface MenuClient {

    Optional<Menu> findById(Long menuId);

    List<Menu> findAllById(List<Long> menuIds);
}
