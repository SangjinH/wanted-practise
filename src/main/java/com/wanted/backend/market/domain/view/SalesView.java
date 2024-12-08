package com.wanted.backend.market.domain.view;

import com.wanted.backend.market.domain.aggregate.Order;
import com.wanted.backend.market.domain.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SalesView {

    private Long id;
    private int quantity;
    private int price;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

    public SalesView(Order order) {
        this.id = order.getId();
        this.quantity = order.getQuantity();
        this.price = order.getPrice();
        this.orderStatus = order.getOrderStatus();
        this.createdAt = order.getCreateAt();
    }
}
