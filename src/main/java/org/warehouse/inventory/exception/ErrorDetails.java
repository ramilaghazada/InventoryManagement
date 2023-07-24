package org.warehouse.inventory.exception;

import java.time.LocalDateTime;

public record ErrorDetails(
        String message,
        String details,
        LocalDateTime timeStamp
) {
}
