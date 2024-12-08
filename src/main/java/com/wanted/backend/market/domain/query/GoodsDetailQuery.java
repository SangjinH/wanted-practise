package com.wanted.backend.market.domain.query;

import com.wanted.backend.market.common.constants.ResponseCode;
import com.wanted.backend.market.common.exceptions.ApiException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor
@ToString
public class GoodsDetailQuery {

    private Long memberId;
    private Long goodsId;

    public GoodsDetailQuery(String inputMemberId, String goodsId) {

        this.memberId = null;
        if (StringUtils.hasText(inputMemberId)) this.memberId = Long.parseLong(inputMemberId);


        try {
            this.goodsId = Long.parseLong(goodsId);
        }
        catch (NumberFormatException nfe) {
            throw new ApiException(ResponseCode.INVALID_PARAMETER);
        }
    }
}
