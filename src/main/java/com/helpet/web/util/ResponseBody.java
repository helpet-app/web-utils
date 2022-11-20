package com.helpet.web.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ResponseBody {
    protected final boolean success;
}
