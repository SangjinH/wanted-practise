package com.wanted.backend.market.domain.exception;

import com.wanted.backend.market.common.constants.ResponseCode;

public class GoodsNotFoundException extends BusinessException {

    public GoodsNotFoundException() {
        super(ResponseCode.GOODS_NOT_FOUND_EXCEPTION);
    }
    public GoodsNotFoundException(String errorMessage) {
        super(ResponseCode.GOODS_NOT_FOUND_EXCEPTION, errorMessage);
    }
}
