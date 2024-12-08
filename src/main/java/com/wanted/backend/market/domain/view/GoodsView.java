package com.wanted.backend.market.domain.view;

import com.wanted.backend.market.domain.aggregate.Goods;
import com.wanted.backend.market.domain.valueobject.GoodsStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsView {

    private Long goodsId;
    private String name;
    private int price;
    private GoodsStatus goodsStatus;

    private List<SalesView> purchaseList;
    private List<SalesView> salesList;

    public GoodsView(Goods goods) {
        this.goodsId = goods.getId();
        this.name = goods.getName();
        this.price = goods.getPrice();
        this.goodsStatus = goods.getStatus();
    }
}
