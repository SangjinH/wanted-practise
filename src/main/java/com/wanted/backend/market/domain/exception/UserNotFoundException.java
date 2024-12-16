package com.wanted.backend.market.domain.exception;

import com.wanted.backend.market.common.constants.ResponseCode;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(String errorMessage) {
        super(ResponseCode.INVALID_PARAMETER, errorMessage);
    }
}
