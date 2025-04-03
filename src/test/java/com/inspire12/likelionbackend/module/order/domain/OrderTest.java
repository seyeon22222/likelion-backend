package com.inspire12.likelionbackend.module.order.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class OrderTest {

    @Test
    void 우선_실패하는테스트_만들기() {
        // TODO junit/assertj 를 통해 실패하게 만들기
        assertThat(1+1).isEqualTo(3);
    }

    @Test
    void 테스트_연습하기_기본_타입_검증() {
        assertThat(1+1).isEqualTo(2);
        assertThat("Hello").isNotEqualTo("World");
        assertThat(true).isTrue();
        assertThat(false).isFalse();
        assertThat(100).isGreaterThan(50);
        assertThat(5).isBetween(1, 10);
    }

}
