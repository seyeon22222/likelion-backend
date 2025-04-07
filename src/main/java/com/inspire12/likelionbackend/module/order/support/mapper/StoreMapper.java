package com.inspire12.likelionbackend.module.order.support.mapper;

import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.StoreEntity;
import com.inspire12.likelionbackend.module.store.domain.Store;

public class StoreMapper {

	// Entity -> Domain
	public static Store fromEntity(StoreEntity entity) {
		return Store.builder()
			.id(entity.getId())
			.storeName(entity.getStoreName())
			.storeNumber(entity.getStoreNumber())
			.createdAt(entity.getCreatedAt())
			.build();
	}
}
