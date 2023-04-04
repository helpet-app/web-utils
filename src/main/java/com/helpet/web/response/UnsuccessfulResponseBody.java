package com.helpet.web.response;

import lombok.Getter;

import java.util.*;

@Getter
public class UnsuccessfulResponseBody extends ResponseBody {
    private final Set<ErrorBody> errors;

    public UnsuccessfulResponseBody(Collection<ErrorBody> errors) {
        super(false);
        this.errors = new HashSet<>(errors);
    }

    public UnsuccessfulResponseBody(ErrorBody error) {
        this(List.of(error));
    }
}
