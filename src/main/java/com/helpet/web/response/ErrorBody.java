package com.helpet.web.response;

import lombok.*;

@EqualsAndHashCode
@Builder
@Data
public class ErrorBody {
    private final String code;

    private final String message;
}
