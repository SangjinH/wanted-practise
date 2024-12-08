package com.wanted.backend.market.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Object> handel(ApiException ae) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("resultCode", ae.getErrorCode());
        headers.add("resultMessage", ae.getErrorMessage());

        return new ResponseEntity<>(headers, ae.getErrorStatus());
    }

}
