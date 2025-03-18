package com.inspire12.likelionbackend.module.order.application.port.in;

import com.inspire12.likelionbackend.module.order.application.service.OrderService;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.support.mapper.OrderPayMapper;
import com.inspire12.likelionbackend.module.payment.application.dto.PayByOrderResult;
import com.inspire12.likelionbackend.module.payment.application.port.out.GetOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderUseCase implements GetOrderPort {

    private final OrderService orderService;

    @Override
    public PayByOrderResult getOrder(String orderNumber) {
        Order order = orderService.getOrderByOrderNumber(orderNumber);
        return OrderPayMapper.toResult(order);
    }
}
