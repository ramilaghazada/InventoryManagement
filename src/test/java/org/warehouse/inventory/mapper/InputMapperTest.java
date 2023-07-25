package org.warehouse.inventory.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.warehouse.inventory.dto.InputDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Input;

import java.time.LocalDateTime;

public class InputMapperTest {
    private final InputMapper inputMapper = new InputMapperImpl();

    @Test
    @DisplayName(value = "DtoToInput")
    void DtoToInput() {
        Card card = new Card("101101", "Card1", "psc", LocalDateTime.now());
        InputDto inputDto = new InputDto(card, 10.0, "card1");
        Input expected = new Input(null, card, 10.0, "card1", null, null);

        Input actual = inputMapper.DtoToInput(inputDto);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "InputToDto")
    void InputToDto() {

        Card card = new Card("101101", "Card1", "psc", LocalDateTime.now());
        Input input = new Input(null, card, 10.0, "card1", null, null);
        InputDto expected = new InputDto(card, 10.0, "card1");

        InputDto actual = inputMapper.InputToDto(input);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
