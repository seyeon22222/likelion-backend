package com.inspire12.likelionbackend.module.hotplace.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HotPlaceRankingService {
    private Logger log = LoggerFactory.getLogger(HotPlaceRankingService.class);
    public Integer getRankings() {
        log.info("get ranking ");
        return 1;
    }
//    private final HotPlaceOrderRepository hotPlaceOrderRepository;

}
