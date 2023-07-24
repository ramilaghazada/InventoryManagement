package org.warehouse.inventory.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.warehouse.inventory.dto.TurnoverDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Turnover;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-25T01:20:38+0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class TurnoverMapperImpl implements TurnoverMapper {

    @Override
    public Turnover DtoToTurnover(TurnoverDto turnoverDto) {
        if ( turnoverDto == null ) {
            return null;
        }

        Turnover turnover = new Turnover();

        turnover.setCard( turnoverDto.card() );
        turnover.setOBalance( turnoverDto.OBalance() );
        turnover.setInput( turnoverDto.input() );
        turnover.setOutput( turnoverDto.output() );
        turnover.setCBalance( turnoverDto.CBalance() );

        return turnover;
    }

    @Override
    public TurnoverDto TurnoverToDto(Turnover turnover) {
        if ( turnover == null ) {
            return null;
        }

        Card card = null;
        Double oBalance = null;
        Double input = null;
        Double output = null;
        Double cBalance = null;

        card = turnover.getCard();
        oBalance = turnover.getOBalance();
        input = turnover.getInput();
        output = turnover.getOutput();
        cBalance = turnover.getCBalance();

        TurnoverDto turnoverDto = new TurnoverDto( card, oBalance, input, output, cBalance );

        return turnoverDto;
    }
}
