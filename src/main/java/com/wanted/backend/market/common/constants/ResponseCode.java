/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 *  or as a whole without the prior written consent of Starbucks Coffee Company.
 *  Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 *  (Copyright (c) 2022 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package com.wanted.backend.market.common.constants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


/**
 * 앱연동 응답 규격
 * */
@Getter
@NoArgsConstructor
public enum ResponseCode {


    /**
     * 공통
     */
    SUCCESS("0000", "정상응답", HttpStatus.OK),
    INVALID_PARAMETER("0099", "요청값에 오류가 있습니다.", HttpStatus.BAD_REQUEST),
    NOT_VALID_ID_PASSWORD("1000", "아이디 혹은 비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED),

    ;

    private String resultCode;
    private String resultMessage;
    private HttpStatus httpStatus;


    ResponseCode(String resultCode, String resultMessage, HttpStatus httpStatus) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.httpStatus = httpStatus;
    }
}