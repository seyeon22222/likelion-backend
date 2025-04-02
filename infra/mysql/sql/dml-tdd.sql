USE
`likelion`;
DELIMITER $$

CREATE PROCEDURE insert_order_test_data()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 1000 DO
        INSERT INTO likelion.orders (customer_id, order_number, total_amount, created_at, status, store_id)
        VALUES (
            FLOOR(1 + RAND() * 100), -- customer_id: 1~100 사이 랜덤
            UUID(),                  -- 주문번호 UUID 생성
            FLOOR(5000 + RAND() * 50000), -- 주문금액: 5천원~5만원 랜덤
            DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 30) DAY), -- 최근 30일 내 날짜 랜덤
            ELT(FLOOR(1 + RAND() * 6), 'CANCELED', 'CANCEL_PAYMENT', 'FAIL_PAYMENT', 'ORDERED', 'PENDING_PAYMENT', 'SUCCESS_PAYMENT'),
            FLOOR(1 + RAND() * 20)   -- store_id: 1~20 사이 랜덤
        );
        SET i = i + 1;
END WHILE;
END $$

DELIMITER ;

CALL insert_order_test_data(); -- 데이터 삽입 실행
