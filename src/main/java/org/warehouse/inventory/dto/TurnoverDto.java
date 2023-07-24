package org.warehouse.inventory.dto;

import jakarta.validation.constraints.NotNull;
import org.warehouse.inventory.entity.Card;

public record TurnoverDto(
        @NotNull
        Card card,
        Double OBalance,
        Double input,
        Double output,
        Double CBalance
) {
}
