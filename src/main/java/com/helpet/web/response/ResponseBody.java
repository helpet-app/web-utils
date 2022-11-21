package com.helpet.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ResponseBody {
    protected final boolean success;
}
