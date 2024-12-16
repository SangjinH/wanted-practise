package com.wanted.backend.market.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppObject<T> {

    private T app;

    public static <T> AppObject<T> appObject(final T t) {
        return AppObject.appObject(t);
    }
}
