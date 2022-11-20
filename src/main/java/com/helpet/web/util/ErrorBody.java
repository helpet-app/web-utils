package com.helpet.web.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorBody {
    private final String code;

    private final String title;

    private final String message;
}
