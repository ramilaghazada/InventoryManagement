package org.warehouse.inventory.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.warehouse.inventory.entity.Card;

public record OBalanceDto(
        @NotNull
        Card card,
        @NotNull
        @Positive
        Double quantity
) {
}
