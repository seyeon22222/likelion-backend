package com.inspire12.likelionbackend.module.hotplace.domain;


import com.inspire12.likelionbackend.module.hotplace.application.HotPlaceService;
import lombok.Getter;


public class HotPlace {
    @Getter
    private double score;

    public HotPlace(double score) {
        this.score = score;
    }


    public Integer getRankings(){
        return 1;
    }
}
