package org.warehouse.inventory.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.warehouse.inventory.dto.CardDto;
import org.warehouse.inventory.entity.Card;

import java.time.LocalDateTime;

public class CardMapperTest {
    private final CardMapper cardMapper = new CardMapperImpl();

    @Test
    @DisplayName(value = "CardToDto")
    void CardToDto(){
//        given
        Card card = new Card("101101", "TestCard", "psc", LocalDateTime.now());
        CardDto expected = new CardDto("101101", "TestCard", "psc");
//        when
        CardDto actual = cardMapper.CardToDto(card);
//        then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "DtoToCard")
    void DtoToCard(){
        CardDto cardDto = new CardDto("101101", "TestCard", "psc");
        Card expected = new Card("101101", "TestCard", "psc", null);

        Card actual = cardMapper.DtoToCard(cardDto);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
