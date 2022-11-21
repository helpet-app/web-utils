package com.helpet.web.response;

import lombok.Getter;

@Getter
public class UnsuccessfulResponseBody extends ResponseBody {
    private final ErrorBody error;

    public UnsuccessfulResponseBody(ErrorBody error) {
        super(false);
        this.error = error;
    }
}
