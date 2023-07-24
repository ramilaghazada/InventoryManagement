package org.warehouse.inventory.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.warehouse.inventory.dto.InputDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Input;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-25T01:20:38+0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class InputMapperImpl implements InputMapper {

    @Override
    public Input DtoToInput(InputDto inputDto) {
        if ( inputDto == null ) {
            return null;
        }

        Input input = new Input();

        input.setCard( inputDto.card() );
        input.setQuantity( inputDto.quantity() );
        input.setNote( inputDto.note() );

        return input;
    }

    @Override
    public InputDto InputToDto(Input input) {
        if ( input == null ) {
            return null;
        }

        Card card = null;
        Double quantity = null;
        String note = null;

        card = input.getCard();
        quantity = input.getQuantity();
        note = input.getNote();

        InputDto inputDto = new InputDto( card, quantity, note );

        return inputDto;
    }
}
