package com.helpet.web.util;

import lombok.Getter;

@Getter
public class SuccessfulResponseBody<T> extends ResponseBody {
    private final T data;

    public SuccessfulResponseBody(T data) {
        super(true);
        this.data = data;
    }
}
