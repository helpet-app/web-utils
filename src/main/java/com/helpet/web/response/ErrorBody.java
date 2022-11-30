package com.helpet.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorBody {
    private final String code;

    private final String message;
}
