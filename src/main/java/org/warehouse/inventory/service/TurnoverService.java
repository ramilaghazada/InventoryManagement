package org.warehouse.inventory.service;

import org.warehouse.inventory.dto.TurnoverDto;
import org.warehouse.inventory.dto.UserDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Turnover;

import java.util.List;

public interface TurnoverService {
    void add(TurnoverDto turnoverDto);
    void deleteByCard(Card card);

    TurnoverDto getByCard(Card card);

    List<TurnoverDto> getAll();

}
