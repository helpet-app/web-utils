package com.helpet.web.response;

import lombok.*;

@Builder
@Data
public class ErrorBody {
    private final String code;

    private final String message;
}
