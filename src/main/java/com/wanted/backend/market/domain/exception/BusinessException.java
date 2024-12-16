package com.wanted.backend.market.domain.exception;

import com.wanted.backend.market.common.constants.ResponseCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

    private String resultCode;
    private String resultMessage;
    private HttpStatus status;

    public BusinessException(ResponseCode responseCode, String errorMessage) {
        this.resultCode = responseCode.getResultCode();
        this.resultMessage = errorMessage;
        this.status = responseCode.getHttpStatus();
    }

    public BusinessException(ResponseCode responseCode) {
        this.resultCode = responseCode.getResultCode();
        this.resultMessage = responseCode.getResultMessage();
        this.status = responseCode.getHttpStatus();
    }
}
