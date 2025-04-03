package com.inspire12.likelionbackend.module.hotplace.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HotPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private final String storeName;

	private final Float score;

	private final List<Reviewer> reviewers = new ArrayList<>();

	private Long ranking;

	@Builder
	public HotPlace(String storeName) {
		this.storeName = storeName;
		this.score = 0F;
		this.ranking = 0L;
	}

	public Float calScore() {
		if (reviewers.isEmpty()) {
			return 0F;
		}
		float sum = 0F;
		for (Reviewer reviewer : reviewers) {
			sum += reviewer.getStar();
		}
		return sum / reviewers.size();
	}

	public void rankingUpdate(Long ranking) {
		this.ranking = ranking;
	}
}
