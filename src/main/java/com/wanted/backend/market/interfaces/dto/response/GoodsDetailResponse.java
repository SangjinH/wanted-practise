package com.wanted.backend.market.interfaces.dto.response;

import com.wanted.backend.market.domain.view.GoodsDetailView;
import com.wanted.backend.market.domain.view.PurchaseView;
import com.wanted.backend.market.domain.view.SalesView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.*;


@Getter
@NoArgsConstructor
public class GoodsDetailResponse {
    private String name;
    private String price;
    private String reservationStatus;
    private String quantity;
    private List<PurchaseResponse> purchaseList;
    private List<SalesResponse> salesList;



    public GoodsDetailResponse(GoodsDetailView detailView) {
        this.name = detailView.getName();
        this.price = String.valueOf(detailView.getPrice());
        this.quantity = String.valueOf(detailView.getQuantity());
        this.reservationStatus = detailView.getGoodsStatus().getDisplayName();
        this.purchaseList = detailView.getPurchaseList().stream().map(PurchaseResponse::new).collect(toList());
        this.salesList = detailView.getSalesList().stream().map(SalesResponse::new).collect(toList());
    }




    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PurchaseResponse {
        private String id;
        private String quantity;
        private String price;
        private String orderStatus;
        private String createdAt;

        public PurchaseResponse(PurchaseView purchaseView) {
            this.id = String.valueOf(purchaseView.getId());
            this.quantity = String.valueOf(purchaseView.getQuantity());
            this.price = String.valueOf(purchaseView.getPrice());
            this.orderStatus = purchaseView.getOrderStatus().getDisplayName();
            this.createdAt = purchaseView.getCreatedAt().toString();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SalesResponse {
        private String id;
        private String quantity;
        private String price;
        private String orderStatus;
        private String createdAt;

        public SalesResponse(SalesView salesView) {
            this.id = String.valueOf(salesView.getId());
            this.quantity = String.valueOf(salesView.getQuantity());
            this.price = String.valueOf(salesView.getPrice());
            this.orderStatus = salesView.getOrderStatus().getDisplayName();
            this.createdAt = salesView.getCreatedAt().toString();
        }
    }
}
