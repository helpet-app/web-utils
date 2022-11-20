package com.helpet.web.util;

import lombok.Getter;

@Getter
public class UnsuccessfulResponseBody extends ResponseBody {
    private final ErrorBody error;

    public UnsuccessfulResponseBody(ErrorBody error) {
        super(false);
        this.error = error;
    }
}
