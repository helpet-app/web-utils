package com.helpet.web.mapper;

import com.helpet.web.response.PageResponse;
import org.springframework.data.domain.Page;

import java.util.Collection;

/**
 * @param <E> Entity type
 * @param <D> DTO type
 */
public interface EntityMapper<E, D> {
    D mapToto(E entity);

    E mapToEntity(D dto);

    Collection<D> mapTotoCollection(Collection<E> entityCollection);

    Collection<E> mapToEntityCollection(Collection<D> dtoCollection);

    default PageResponse<D> mapTotoPage(Page<E> entityPage) {
        Page<D> dtoPage = entityPage.map(this::mapToto);
        return PageResponse.of(dtoPage);
    }
}