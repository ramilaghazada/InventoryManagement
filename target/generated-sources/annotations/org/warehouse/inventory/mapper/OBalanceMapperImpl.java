package org.warehouse.inventory.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.warehouse.inventory.dto.OBalanceDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.OBalance;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-25T01:20:38+0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class OBalanceMapperImpl implements OBalanceMapper {

    @Override
    public OBalance DtoToOBalance(OBalanceDto oBalanceDto) {
        if ( oBalanceDto == null ) {
            return null;
        }

        OBalance oBalance = new OBalance();

        oBalance.setCard( oBalanceDto.card() );
        oBalance.setQuantity( oBalanceDto.quantity() );

        return oBalance;
    }

    @Override
    public OBalanceDto OBalanceToDto(OBalance oBalance) {
        if ( oBalance == null ) {
            return null;
        }

        Card card = null;
        Double quantity = null;

        card = oBalance.getCard();
        quantity = oBalance.getQuantity();

        OBalanceDto oBalanceDto = new OBalanceDto( card, quantity );

        return oBalanceDto;
    }
}
