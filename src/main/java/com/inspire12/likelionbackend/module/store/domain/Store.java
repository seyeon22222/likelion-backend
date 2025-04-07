package com.inspire12.likelionbackend.module.store.domain;

import java.time.LocalDateTime;

import lombok.Builder;

public class Store {

	private Long id;
	private Boolean isOpen;
	private LocalDateTime createdAt;
	private String storeName;
	private String storeNumber;


	@Builder
	public Store(Long id, Boolean isOpen, LocalDateTime createdAt, String storeName, String storeNumber) {
		this.id = id;
		this.isOpen = isOpen;
		this.createdAt = createdAt;
		this.storeName = storeName;
		this.storeNumber = storeNumber;
	}

	public Boolean getIsOpen() {
		return LocalDateTime.now().getHour() >= 11 && LocalDateTime.now().getHour() <= 22;
	}
}
