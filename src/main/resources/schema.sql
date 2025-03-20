use likelion;
CREATE DATABASE IF NOT EXISTS `likelion`;
USE `likelion`;

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
                          `created_at` datetime(6) DEFAULT NULL,
                          `customer_id` bigint DEFAULT NULL,
                          `delivery_price` bigint DEFAULT NULL,
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `store_id` bigint DEFAULT NULL,
                          `store_price` bigint DEFAULT NULL,
                          `total_price` bigint DEFAULT NULL,
                          `updated_at` datetime(6) DEFAULT NULL,
                          `order_number` binary(16) DEFAULT NULL,
                          `delivery_status` enum('APPROVE','BEFORE_PAYMENT','CANCEL','COMPLETE','ING','PENDING') DEFAULT NULL,
                          `order_status` enum('CANCEL_PAYMENT','FAIL_PAYMENT','PENDING_PAYMENT') DEFAULT NULL,
                          `order_type` enum('DELIVERY','PICKUP') DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



