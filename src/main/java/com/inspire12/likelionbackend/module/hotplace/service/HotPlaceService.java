package com.inspire12.likelionbackend.module.hotplace.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inspire12.likelionbackend.module.hotplace.domain.HotPlace;

@Service
public class HotPlaceService {

	public void makeRanking(List<HotPlace> hotPlacesList) {

		Collections.sort(hotPlacesList, new Comparator<HotPlace>() {
			@Override
			public int compare(HotPlace o1, HotPlace o2) {
				return o2.getScore().compareTo(o1.getScore());
			}
		});

		// Update the ranking based on the sorted order
		for (int i = 0; i < hotPlacesList.size(); ++i) {
			hotPlacesList.get(i).rankingUpdate((long) i + 1);
		}


	}
}
