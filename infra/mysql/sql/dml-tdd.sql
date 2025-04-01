USE
`likelion`;

DELIMITER //
CREATE PROCEDURE insert_sample_orders()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 100 DO
        INSERT INTO orders (customer_id, order_number, total_amount, created_at) VALUES
        (
            FLOOR(101 + RAND() * 8),          -- customer_id: 101 ~ 108
            UUID(),                            -- order_number: 랜덤 UUID
            FLOOR(8000 + RAND() * 25000),      -- total_amount: 8,000 ~ 33,000원
            TIMESTAMP(DATE('2024-04-01') + INTERVAL FLOOR(RAND() * 86400) SECOND) -- 랜덤 시간 생성
        );
        SET i = i + 1;
END WHILE;
END //
DELIMITER ;

-- 실행 방법:
CALL insert_sample_orders();