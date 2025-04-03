package com.inspire12.likelionbackend.module.hotplace.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.inspire12.likelionbackend.module.hotplace.service.HotPlaceService;

/*
 **요구 사항**
1. 별점과 리뷰
2. 각 맛집의 별점의 평균 계산 -> 맛집 순위가 매겨짐
3. 실시간 X, 새로운 평가가 생겼거나, 기존의 평가가 수정되었을 경우 갱신
4. 한사람이 여러번 했을 경우, 가장 최신의 결과만 반영이 되도록
5. 언제나 리뷰 및 별점은 수정, 삭제가 가능 -> 이 경우 별점에 바로 반영이 되도록
6. 별점은 1~5점으로 제한 -> 프론트에서 제한 알림 발생 / 백엔드에서는 1~5점으로만 받음
7. 리뷰 필수 + 최소 10자 입력
8. 리뷰 + 별점만 가능 / 별점만 따로 있다거나 이러면 안됨
9. 평가가 하나도 없는경우 랭킹에서 제외


**핵심 기능**
1. 별점 + 리뷰
2. 평균 계산을 통한 랭킹순위 집계
3. 실시간은 아니고 업데이트가 발생했을 경우, 반영

**예외 처리**
1. 별점은 1~5점으로 제한
2. 리뷰는 필수 + 최소 10자 입력
3. 리뷰 + 별점만 가능
4. 한사람이 여러번 했을 경우, 가장 최신의 결과만 반영이 되도록
5. 리뷰 및 별점은 수정, 삭제가 가능
 */

class HotPlaceTest {
    /*
     TODO 맛집 랭킹 기획을 구체화해 명세로 만들고 테스트로 적자
     */

	@Test
	void 별점_리뷰_작성하기() {
		// given
		List<HotPlace> hotPlaceList = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			hotPlaceList.add(new HotPlace("신규 생성 " + i));
		}
		List<Reviewer> reviewerList = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			reviewerList.add(new Reviewer(hotPlaceList.get(i), "맛있어요", ((long)(i + 1))));
		}

		// when

		// then
		assertEquals(5, hotPlaceList.size());
		assertTrue(reviewerList.get(0).getStar() >= 1 && reviewerList.get(0).getStar() <= 5);
	}

	@Test
	void 랭킹_순위_집계하기()  {
		// given
		List<HotPlace> hotPlaceList = new ArrayList<>();
		HotPlace hotPlace1 = new HotPlace("신규 생성1");
		HotPlace hotPlace2 = new HotPlace("신규 생성2");
		hotPlaceList.add(hotPlace1);
		hotPlaceList.add(hotPlace2);

		// when
		List<Reviewer> reviewerList = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			Reviewer reviewer = new Reviewer(hotPlace1, "맛있어요", ((long)(i + 1)));
			reviewerList.add(reviewer);
			reviewer.addReviewer(reviewer);
		}

		for (int i = 0; i < 5; ++i) {
			Reviewer reviewer = new Reviewer(hotPlace2, "별로에요", 1L);
			reviewerList.add(reviewer);
			reviewer.addReviewer(reviewer);
		}

		HotPlaceService hotPlaceService = new HotPlaceService();
		hotPlaceService.makeRanking(hotPlaceList);

		//then
		assertEquals(3, hotPlace1.calScore());
		assertEquals(1, hotPlace2.calScore());
		assertTrue(hotPlace1.calScore() > hotPlace2.calScore());
		assertEquals(1L, hotPlace1.getRanking());
		assertEquals(2L, hotPlace2.getRanking());
	}

}