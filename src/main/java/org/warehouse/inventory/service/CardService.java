package org.warehouse.inventory.service;

import org.warehouse.inventory.dto.CardDto;

import java.util.List;

public interface CardService {
    void add(CardDto cardDto);

    void delete(String id);

    void update(String id, CardDto cardDto);

    void clear();

    CardDto getById(String id);

    List<CardDto> getAll();

}
