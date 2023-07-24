package org.warehouse.inventory.service;

import org.warehouse.inventory.dto.OBalanceDto;

import java.util.List;

public interface OBalanceService {
    void add(OBalanceDto oBalanceDto);

    void delete(Integer id);

    void update(Integer id, OBalanceDto oBalanceDto);

    void clear();

    OBalanceDto getById(Integer id);

    List<OBalanceDto> getAll();
}
