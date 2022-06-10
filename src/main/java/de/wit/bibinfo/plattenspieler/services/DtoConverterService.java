package de.wit.bibinfo.plattenspieler.services;

import java.util.List;

public interface DtoConverterService<T, E> {

    /**
     *
     * @param entities
     * @return
     */
    List<T> convertToDto(List<E> entities);

    /**
     *
     * @param entity
     * @return
     */
    T convertToDto(E entity);

    E convertToEntity(T dto);

}
