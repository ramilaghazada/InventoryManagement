package org.warehouse.inventory.mapper;

import org.mapstruct.Mapper;
import org.warehouse.inventory.dto.OBalanceDto;
import org.warehouse.inventory.entity.OBalance;

@Mapper(componentModel = "spring")
public interface OBalanceMapper {

    OBalance DtoToOBalance(OBalanceDto oBalanceDto);

    OBalanceDto OBalanceToDto(OBalance oBalance);
}
