package com.onma.dto.base;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@SuperBuilder
@RequiredArgsConstructor
public abstract class AbstractDTO {
    private Long id;
}
