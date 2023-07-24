package org.warehouse.inventory.mapper;

import org.mapstruct.Mapper;
import org.warehouse.inventory.dto.InputDto;
import org.warehouse.inventory.entity.Input;

@Mapper(componentModel = "spring")
public interface InputMapper {

    Input DtoToInput(InputDto inputDto);

    InputDto InputToDto(Input input);
}
