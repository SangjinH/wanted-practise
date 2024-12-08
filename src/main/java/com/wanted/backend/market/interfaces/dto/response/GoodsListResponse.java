package com.wanted.backend.market.interfaces.dto.response;

import com.wanted.backend.market.domain.view.GoodsView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class GoodsListResponse {

    private List<GoodsDto> goodsList;

    @Getter
    @NoArgsConstructor
    public class GoodsDto {
        private String goodsId;
        private String name;
        private String price;
        private String reservationStatus;

        public GoodsDto(GoodsView goodsView) {
            this.goodsId = String.valueOf(goodsView.getGoodsId());
            this.name = goodsView.getName();
            this.price = String.valueOf(goodsView.getPrice());
            this.reservationStatus = goodsView.getGoodsStatus().getDisplayName();
        }
    }


    public GoodsListResponse(List<GoodsView> goodsViewList) {
        this.goodsList = goodsViewList.stream()
                .map(GoodsDto::new)
                .collect(Collectors.toList());
    }

}
