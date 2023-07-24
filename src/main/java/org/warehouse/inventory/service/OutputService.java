package org.warehouse.inventory.service;

import org.warehouse.inventory.dto.OutputDto;

import java.util.List;

public interface OutputService {

    void add(OutputDto outputDto);

    void delete(Integer id);

    void update(Integer id, OutputDto outputDto);

    void clear();

    OutputDto getById(Integer id);

    List<OutputDto> getAll();
}
