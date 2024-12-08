package com.wanted.backend.market.interfaces;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

import static com.wanted.backend.market.common.constants.ResponseCode.SUCCESS;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BasicController {

    public HttpHeaders getSuccessHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("resultCode", SUCCESS.getResultCode());
        headers.set("resultMessage", URLEncoder.encode(SUCCESS.getResultMessage()));
        return headers;
    }

}
