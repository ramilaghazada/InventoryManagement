package org.warehouse.inventory.dto;

import jakarta.validation.constraints.NotNull;

public record CardDto(
        @NotNull
        String id,
        @NotNull
        String description,
        @NotNull
        String unit
) {
}
