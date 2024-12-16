package com.wanted.backend.market.common.model;

import com.wanted.backend.market.common.model.AppObject;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiResponse {

    private String resultCode;
    private String resultMessage;
    private AppObject<Object> resultBody;

    public ApiResponse(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }
}
