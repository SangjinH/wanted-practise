package com.wanted.backend.market.common.exceptions;

import com.wanted.backend.market.common.constants.ResponseCode;
import com.wanted.backend.market.common.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.wanted.backend.market.common.constants.Constants.RESULT_CODE;
import static com.wanted.backend.market.common.constants.Constants.RESULT_MESSAGE;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {


    /*
    * Controller 에서 Valid 를 사용했을 시, 호출
    * BindingResult : @Valid를 통과하지 못한 어노테이션들을 모아둠
    */
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        BindingResult bindingResult = ex.getBindingResult();
        String resultMessage = "";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            resultMessage = fieldError.getDefaultMessage();
            break;
        }

        ResponseCode invalidResponseCode = ResponseCode.INVALID_PARAMETER;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(RESULT_CODE, invalidResponseCode.getResultCode());
        httpHeaders.add(RESULT_MESSAGE, URLEncoder.encode(invalidResponseCode.getResultMessage(), StandardCharsets.UTF_8));
        ApiResponse apiResponse = new ApiResponse(invalidResponseCode.getResultCode(), resultMessage);
        return new ResponseEntity<>(apiResponse, httpHeaders, invalidResponseCode.getHttpStatus());
    }
}
