package org.warehouse.inventory.mapper;

import org.mapstruct.Mapper;
import org.warehouse.inventory.dto.CardDto;
import org.warehouse.inventory.entity.Card;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card DtoToCard(CardDto cardDto);

    CardDto CardToDto(Card card);
}
