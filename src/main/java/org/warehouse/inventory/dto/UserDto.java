package org.warehouse.inventory.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotNull
        String id,
        @NotNull
        String fullName,
        @NotNull
        @Email
        String email,
        @NotNull
        String password
) {
}
