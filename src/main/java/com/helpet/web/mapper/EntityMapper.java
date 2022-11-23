package com.helpet.web.mapper;

import com.helpet.web.response.PageResponse;
import org.springframework.data.domain.Page;

import java.util.Collection;

/**
 * @param <E> Entity type
 * @param <D> DTO type
 */
public interface EntityMapper<E, D> {
    D mapToDto(E entity);

    E mapToEntity(D dto);

    Collection<D> mapToDtoCollection(Collection<E> entityCollection);

    Collection<E> mapToEntityCollection(Collection<D> dtoCollection);

    default PageResponse<D> mapToDtoPage(Page<E> entityPage) {
        Page<D> dtoPage = entityPage.map(this::mapToDto);
        return PageResponse.of(dtoPage);
    }
}