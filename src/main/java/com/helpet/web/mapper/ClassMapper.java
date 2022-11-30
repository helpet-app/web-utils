package com.helpet.web.mapper;

import com.helpet.web.response.PageResponse;
import org.springframework.data.domain.Page;

import java.util.Collection;

/**
 * @param <S> Source type
 * @param <T> Target type
 */
public interface ClassMapper<S, T> {
    T map(S source);

    Collection<T> mapCollection(Collection<S> sourceCollection);

    default PageResponse<T> mapPage(Page<S> sourcePage) {
        Page<T> dtoPage = sourcePage.map(this::map);
        return PageResponse.of(dtoPage);
    }
}