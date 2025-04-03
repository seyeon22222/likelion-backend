package com.inspire12.likelionbackend.module.hotplace.application;

import com.inspire12.likelionbackend.module.hotplace.domain.HotPlace;
import org.springframework.stereotype.Service;

@Service
public class HotPlaceService {
    private final HotPlaceRankingService hotPlaceRankingService;

    public HotPlaceService(HotPlaceRankingService hotPlaceRankingService) {
        this.hotPlaceRankingService = hotPlaceRankingService;
    }

    public boolean validate(HotPlace hotPlace) {
        Integer rankings = hotPlaceRankingService.getRankings();
        if(rankings <= 10) {
            return (int)hotPlace.getScore() == hotPlace.getScore();
        }
        return false;
    }

}
