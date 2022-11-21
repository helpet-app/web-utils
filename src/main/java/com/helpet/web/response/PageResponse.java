package com.helpet.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@AllArgsConstructor
@Data
public class PageResponse<T> {
    private int totalNumberOfPages;

    private long totalNumberOfElements;

    private int size;

    private int number;

    private int numberOfElements;

    private List<T> content;

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
