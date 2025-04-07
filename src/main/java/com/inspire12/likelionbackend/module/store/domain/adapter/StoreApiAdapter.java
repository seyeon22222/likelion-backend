package com.inspire12.likelionbackend.module.store.domain.adapter;

import com.inspire12.likelionbackend.module.order.application.port.out.StoreStatusPort;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.StoreJpaRepository;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.StoreEntity;
import com.inspire12.likelionbackend.module.order.support.mapper.StoreMapper;
import com.inspire12.likelionbackend.module.store.domain.Store;

import org.springframework.stereotype.Component;

//  TODO: Order에서 만든 StoreStatusPort포트를 implements 해서 기능 구현
@Component
public class StoreApiAdapter implements StoreStatusPort{

	private final StoreJpaRepository storeJpaRepository;

	public StoreApiAdapter(StoreJpaRepository storeJpaRepository) {
		this.storeJpaRepository = storeJpaRepository;
	}

	@Override
	public Boolean getStoreOpenStatus(Long storeId) {
		StoreEntity storeEntity = storeJpaRepository.findByStoreId(storeId).orElseThrow(
			() -> new IllegalArgumentException("가계가 존재하지 않습니다.")
		);

		Store store = StoreMapper.fromEntity(storeEntity);

		return store.getIsOpen();
	}
}
