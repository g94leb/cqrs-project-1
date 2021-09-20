package com.app.aggregate;

import com.app.command.AddItemCommand;
import com.app.event.ItemCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class ItemAggregate {
    @AggregateIdentifier
    private Long itemId;
    private Double price;
    private Integer quantity;
    private String description;

    @CommandHandler
    public ItemAggregate(AddItemCommand command) {
        AggregateLifecycle.apply(
                new ItemCreatedEvent(command.getItemId(),
                        command.getPrice(),
                        command.getQuantity(),
                        command.getDescription())
        );
    }

    @EventSourcingHandler
    public void on(ItemCreatedEvent event) {
        this.itemId = event.getItemId();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
        this.description = event.getDescription();
    }
}
