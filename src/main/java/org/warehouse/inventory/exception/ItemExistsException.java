package org.warehouse.inventory.exception;

public class ItemExistsException extends RuntimeException {
    public ItemExistsException() {
        super("Item exists!");
    }
}
