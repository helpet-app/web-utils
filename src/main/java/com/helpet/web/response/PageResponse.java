package com.helpet.web.response;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageResponse<T> {
    private final int totalNumberOfPages;

    private final long totalNumberOfElements;

    private final int size;

    private final int number;

    private final int numberOfElements;

    private final List<T> content;

    public PageResponse(Page<T> page) {
        this.totalNumberOfPages = page.getTotalPages();
        this.totalNumberOfElements = page.getTotalElements();
        this.size = page.getSize();
        this.number = page.getNumber();
        this.numberOfElements = page.getNumberOfElements();
        this.content = page.getContent();
    }

    public static <T> PageResponse<T> of(Page<T> page) {
        return new PageResponse<>(page);
    }
}
