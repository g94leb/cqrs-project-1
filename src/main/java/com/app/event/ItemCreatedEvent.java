package com.app.event;

import lombok.Data;

@Data
public class ItemCreatedEvent {
    private final Long itemId;
    private final Double price;
    private final Integer quantity;
    private final String description;
}
