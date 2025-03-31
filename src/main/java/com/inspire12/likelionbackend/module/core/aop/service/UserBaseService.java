package com.inspire12.likelionbackend.module.core.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserBaseService {

    private static final Logger log = LoggerFactory.getLogger(UserBaseService.class.getName());

    public void registerUser(String username, String email) {
        // 로깅
        log.info("사용자 등록 시작 - username: {}", username);
        // 유효성 검사
        if (username == null || email == null) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        // 이메일 검증
        if (!email.endsWith("@example.com")) {
            throw new SecurityException("허용되지 않은 이메일 도메인입니다.");
        }
        // 핵심 로직
        log.info("DB에 사용자 저장 로직 실행");
        // 로깅
        log.info("사용자 등록 완료 - username: {}", username);
    }
}
