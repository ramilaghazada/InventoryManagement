package org.warehouse.inventory.exception;

public class ItemHasTurnoverException extends RuntimeException {
    public ItemHasTurnoverException(){
        super("Item has turnover!");
    }
}
