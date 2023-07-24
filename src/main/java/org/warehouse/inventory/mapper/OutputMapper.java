package org.warehouse.inventory.mapper;

import org.mapstruct.Mapper;
import org.warehouse.inventory.dto.OutputDto;
import org.warehouse.inventory.entity.Output;

@Mapper(componentModel = "spring")
public interface OutputMapper {
    Output DtoToOutput(OutputDto outputDto);

    OutputDto OutputToDto(Output output);
}
