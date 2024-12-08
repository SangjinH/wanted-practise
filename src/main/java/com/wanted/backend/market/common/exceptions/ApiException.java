package com.wanted.backend.market.common.exceptions;

import com.wanted.backend.market.common.constants.ResponseCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Getter
@NoArgsConstructor
public class ApiException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
    private HttpStatus errorStatus;

    public ApiException(ResponseCode responseCode) {
        this.errorCode = responseCode.getResultCode();
        this.errorMessage = URLEncoder.encode(responseCode.getResultMessage(), StandardCharsets.UTF_8);
        this.errorStatus = responseCode.getHttpStatus();
    }

    public ApiException(ResponseCode responseCode, String errorMessage) {
        this.errorCode = responseCode.getResultCode();
        this.errorMessage = URLEncoder.encode(errorMessage, StandardCharsets.UTF_8);
        this.errorStatus = responseCode.getHttpStatus();
    }
}
