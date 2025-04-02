package com.inspire12.likelionbackend.module.core.threadlocal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.inspire12.likelionbackend.module.core.threadlocal.context.UserContextHolder;

@Service
public class UserPartPartService {
    private static Logger log = LoggerFactory.getLogger(UserPartPartService.class);

    public String useCurrentUsername() {
//        TODO 함수 시그니처를 수정하지 말고 username 을 찍어보기
//         String username = "FIX ME";
        String username = UserContextHolder.getUser();
        log.info("username : {}", username);
        return username;
    }
}
