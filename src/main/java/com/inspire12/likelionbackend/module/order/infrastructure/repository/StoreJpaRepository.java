package com.inspire12.likelionbackend.module.order.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.StoreEntity;

@Component
public interface StoreJpaRepository extends JpaRepository<StoreEntity, Long> {
	Optional<StoreEntity> findByStoreId(Long storeId);
	StoreEntity findByStoreName(String storeName);
	StoreEntity findByStoreNumber(String storeNumber);
}
