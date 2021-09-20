package com.app.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddItemCommand {

    @TargetAggregateIdentifier
    private Long itemId;
    private Double price;
    private Integer quantity;
    private String description;
}
