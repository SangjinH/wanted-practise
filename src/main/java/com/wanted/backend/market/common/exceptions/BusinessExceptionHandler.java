package com.wanted.backend.market.common.exceptions;

import com.wanted.backend.market.common.model.ApiResponse;
import com.wanted.backend.market.domain.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.wanted.backend.market.common.constants.Constants.RESULT_CODE;
import static com.wanted.backend.market.common.constants.Constants.RESULT_MESSAGE;

@Slf4j
@RestControllerAdvice
public class BusinessExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handle(BusinessException be, WebRequest req) {

        HttpHeaders headers = new HttpHeaders();
        String errorCode = be.getResultCode();
        String errorMessage = be.getResultMessage();
        headers.add(RESULT_CODE, errorCode);
        headers.add(RESULT_MESSAGE, URLEncoder.encode(errorMessage, StandardCharsets.UTF_8));

        HttpStatus status = be.getStatus();
        ApiResponse apiResponse = new ApiResponse(errorCode, errorMessage);
        return new ResponseEntity<>(apiResponse, headers, status);
    }
}