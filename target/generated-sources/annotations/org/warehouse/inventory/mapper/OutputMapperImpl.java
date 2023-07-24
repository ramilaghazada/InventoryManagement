package org.warehouse.inventory.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.warehouse.inventory.dto.OutputDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Output;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-25T01:20:38+0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class OutputMapperImpl implements OutputMapper {

    @Override
    public Output DtoToOutput(OutputDto outputDto) {
        if ( outputDto == null ) {
            return null;
        }

        Output output = new Output();

        output.setCard( outputDto.card() );
        output.setQuantity( outputDto.quantity() );
        output.setNote( outputDto.note() );

        return output;
    }

    @Override
    public OutputDto OutputToDto(Output output) {
        if ( output == null ) {
            return null;
        }

        Card card = null;
        Double quantity = null;
        String note = null;

        card = output.getCard();
        quantity = output.getQuantity();
        note = output.getNote();

        OutputDto outputDto = new OutputDto( card, quantity, note );

        return outputDto;
    }
}
