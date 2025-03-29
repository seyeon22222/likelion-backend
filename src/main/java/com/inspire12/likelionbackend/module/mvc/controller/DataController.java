package com.inspire12.likelionbackend.module.mvc.controller;

import com.inspire12.likelionbackend.module.mvc.model.Customer;
import com.inspire12.likelionbackend.module.mvc.model.OrderRequest;
import com.inspire12.likelionbackend.module.mvc.model.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RequestMapping(("/rest"))
@RestController
public class DataController { // 뜬금 질문, 제가 왜 클래스명을 RestController 로 만들었을까요?

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @PostMapping("/order/{username}")
    public ResponseEntity<OrderResponse> getOrder(@RequestParam Long id, @PathVariable String username,
                                                 @RequestBody OrderRequest orderRequest,
                                                 @RequestHeader HttpHeaders headers,
                                                 @RequestHeader("user-id") Long userId,
                                                  Customer customer
                                  ) {

        log.info("param {}", id);
        log.info("pathVariable {}", username);
        log.info("body {}", orderRequest);
        log.info("header {}", headers);
        if (id == null || userId == null || orderRequest == null || username == null || customer == null) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(new OrderResponse(userId, orderRequest.getProductId(), LocalDateTime.now()));

    }
}
