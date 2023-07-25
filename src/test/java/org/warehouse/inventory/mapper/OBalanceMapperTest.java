package org.warehouse.inventory.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.warehouse.inventory.dto.OBalanceDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.OBalance;
import org.warehouse.inventory.entity.User;

import java.time.LocalDateTime;

public class OBalanceMapperTest {
    private final OBalanceMapper mapper = new OBalanceMapperImpl();

    @Test
    @DisplayName(value = "OBalanceToDto")
    void OBalanceToDto(){
        Card card = new Card("101101", "Card1", "psc", LocalDateTime.now());
        OBalance oBalance = new OBalance(null, card, 10.0, null, LocalDateTime.now());
        OBalanceDto expected = new OBalanceDto(card, 10.0);

        OBalanceDto actual = mapper.OBalanceToDto(oBalance);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "DtoToOBalance")
    void DtoToOBalance(){

    }
}
