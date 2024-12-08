package com.wanted.backend.market.interfaces;

import com.wanted.backend.market.common.interceptor.LoginCheck;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginTestController extends BasicController {

    @PostMapping
    @LoginCheck
    public ResponseEntity test() {
        return new ResponseEntity(getSuccessHeader(), HttpStatus.OK);
    }
}
