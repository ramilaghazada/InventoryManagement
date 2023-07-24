package org.warehouse.inventory.service;

import org.warehouse.inventory.dto.InputDto;

import java.util.List;

public interface InputService {
    void add(InputDto inputDto);

    void delete(Integer id);

    void update(Integer id, InputDto inputDto);

    void clear();

    InputDto getById(Integer id);

    List<InputDto> getAll();
}
