package com.inspire12.likelionbackend.module.hotplace.domain;

import org.hibernate.annotations.Collate;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
public class Reviewer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private final HotPlace hotPlace;

	@Column(columnDefinition = "TEXT", nullable = false)
	@Size(min = 10, message = "리뷰는 최소 10자 이상 입력해야 합니다.")
	private final String content;

	@Min(1)
	@Max(5)
	@Column(nullable = false)
	private final Long star;


	@Builder
	public Reviewer(HotPlace hotPlace, String content, Long star) {
		this.hotPlace = hotPlace;
		this.content = content;
		this.star = star;
	}

	public void addReviewer(Reviewer reviewer) {
		this.hotPlace.getReviewers().add(reviewer);
		this.hotPlace.calScore();
	}
}
