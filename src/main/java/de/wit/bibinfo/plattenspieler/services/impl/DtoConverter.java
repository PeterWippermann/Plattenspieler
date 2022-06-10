package de.wit.bibinfo.plattenspieler.services.impl;

import org.modelmapper.ModelMapper;

import java.util.List;

abstract class DtoConverter<T, E> {

    interface ConstructOperator<T, E> {
        T construct(E entity);
    }

    final ModelMapper modelMapper;

    protected DtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<T> convertToDto(List<E> entities, ConstructOperator<T, E> constructOperator) {
        return entities.stream()
                .map(e -> this.convertToDto(e, constructOperator))
                .toList();
    }

    public T convertToDto(E entity, ConstructOperator<T, E> constructOperator) {
        T dto = constructOperator.construct(entity);
        this.modelMapper.map(entity, dto);

        return dto;
    }

    public E convertToEntity(T dto, ConstructOperator<E, T> constructOperator) {
        E entity = constructOperator.construct(dto);
        this.modelMapper.map(dto, entity);

        return entity;
    }

}
