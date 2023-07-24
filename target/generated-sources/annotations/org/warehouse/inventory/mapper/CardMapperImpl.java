package org.warehouse.inventory.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.warehouse.inventory.dto.CardDto;
import org.warehouse.inventory.entity.Card;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-25T01:20:38+0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class CardMapperImpl implements CardMapper {

    @Override
    public Card DtoToCard(CardDto cardDto) {
        if ( cardDto == null ) {
            return null;
        }

        Card card = new Card();

        card.setId( cardDto.id() );
        card.setDescription( cardDto.description() );
        card.setUnit( cardDto.unit() );

        return card;
    }

    @Override
    public CardDto CardToDto(Card card) {
        if ( card == null ) {
            return null;
        }

        String id = null;
        String description = null;
        String unit = null;

        id = card.getId();
        description = card.getDescription();
        unit = card.getUnit();

        CardDto cardDto = new CardDto( id, description, unit );

        return cardDto;
    }
}
