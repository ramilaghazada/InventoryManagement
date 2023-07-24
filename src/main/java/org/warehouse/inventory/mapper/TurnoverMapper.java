package org.warehouse.inventory.mapper;

import org.mapstruct.Mapper;
import org.warehouse.inventory.dto.TurnoverDto;
import org.warehouse.inventory.entity.Turnover;

@Mapper(componentModel = "spring")
public interface TurnoverMapper {
    Turnover DtoToTurnover(TurnoverDto turnoverDto);

    TurnoverDto TurnoverToDto(Turnover turnover);
}
