package com.wanted.backend.market.domain.view;

import com.wanted.backend.market.domain.aggregate.Goods;
import com.wanted.backend.market.domain.aggregate.Order;
import com.wanted.backend.market.domain.valueobject.GoodsStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsDetailView {

    private Long goodsId;
    private String name;
    private int price;
    private int quantity;
    private GoodsStatus goodsStatus;

    private List<SalesView> salesList;
    private List<PurchaseView> purchaseList;


    public GoodsDetailView(Goods goods) {
        this.goodsId = goods.getId();
        this.name = goods.getName();
        this.price = goods.getPrice();
        this.quantity = goods.getQuantity();
        this.goodsStatus = goods.getStatus();
        this.salesList = new ArrayList<>();
        this.purchaseList = new ArrayList<>();
    }

    public static GoodsDetailView getSalesDetailView(Goods goods, List<Order> salesList) {
        return GoodsDetailView.builder()
                .goodsId(goods.getId())
                .name(goods.getName())
                .price(goods.getPrice())
                .quantity(goods.getQuantity())
                .goodsStatus(goods.getStatus())
                .salesList(salesList.stream().map(SalesView::new).collect(Collectors.toList()))
                .purchaseList(new ArrayList<>())
                .build();
    }

    public static GoodsDetailView getPurchaseDetailView(Goods goods, List<Order> purchaseList) {
        return GoodsDetailView.builder()
                .goodsId(goods.getId())
                .name(goods.getName())
                .price(goods.getPrice())
                .quantity(goods.getQuantity())
                .goodsStatus(goods.getStatus())
                .salesList(new ArrayList<>())
                .purchaseList(purchaseList.stream().map(PurchaseView::new).collect(Collectors.toList()))
                .build();
    }
}
