/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Starbucks Coffee Company.
 * Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 * (Copyright ⓒ2021 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package com.wanted.backend.market.domain.valueobject;

import lombok.Getter;

@Getter
public enum GoodsStatus {
    ON_SALE("판매중"),
    RESERVED("예약중"),
    COMPLETED("완료")

    ;

    private String displayName;

    GoodsStatus(String displayName) {
        this.displayName = displayName;
    }
}
