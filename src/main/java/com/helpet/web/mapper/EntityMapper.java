package com.helpet.web.mapper;

import com.helpet.web.dto.PageResponse;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface EntityMapper<T1, T2 extends MappingDto> {
    T2 mapToDto(T1 entity);

    T1 mapToEntity(T2 dto);

    Collection<T2> mapToDtoCollection(Collection<T1> entityCollection);

    Collection<T1> mapToEntityCollection(Collection<T2> dtoCollection);

    default PageResponse<T2> mapToDtoPage(Page<T1> entityPage) {
        Page<T2> dtoPage = entityPage.map(this::mapToDto);
        return PageResponse.of(dtoPage);
    }
}