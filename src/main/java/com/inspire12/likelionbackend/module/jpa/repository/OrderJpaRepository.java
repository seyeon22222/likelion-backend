package com.inspire12.likelionbackend.module.jpa.repository;

import com.inspire12.likelionbackend.module.jpa.model.dto.OrderSum;
import com.inspire12.likelionbackend.module.jpa.model.dto.OrderSummary;
import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

	@Query("select o from OrderEntity o where o.id=:orderId")
	Optional<OrderEntity> findByOrderId(Long orderId);

	@Query(
		"SELECT new com.inspire12.likelionbackend.module.jpa.model.dto.OrderSummary(o.id, o.orderNumber, o.totalAmount) "
			+ "FROM OrderEntity o WHERE o.customerId = :customerId")
	List<OrderSummary> findOrderSummariesByCustomerId(@Param("customerId") Long customerId);

	// TODO
	@Query("SELECT new com.inspire12.likelionbackend.module.jpa.model.dto.OrderSum(o.customerId, sum(o.totalAmount)) "
		+ "FROM OrderEntity o WHERE o.customerId=:customerId")
	OrderSum sumAmountByUserId(@Param("customerId")Long customerId);


	@Query("select o from OrderEntity o where o.id=:Id")
	Optional<OrderEntity> selectById(Long Id);

	@Modifying
	@Query("update OrderEntity o set o.totalAmount = :newAmount where o.customerId = :id")
	void updateAmountById(@Param("id") Long id, @Param("newAmount") Integer newAmount);

}
