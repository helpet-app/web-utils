package com.helpet.web.response;

import lombok.Getter;

@Getter
public class SuccessfulResponseBody<T> extends ResponseBody {
    private final T data;

    public SuccessfulResponseBody(T data) {
        super(true);
        this.data = data;
    }
}
