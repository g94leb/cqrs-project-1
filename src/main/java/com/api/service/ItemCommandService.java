package com.api.service;

import com.api.dto.ItemDTO;
import com.app.command.AddItemCommand;
import com.app.entity.Item;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class ItemCommandService {
    private final CommandGateway commandGateway;

    public CompletableFuture<Item> addItem(ItemDTO itemDTO) {
        return this.commandGateway.send(new AddItemCommand(
                itemDTO.getItemId(),
                itemDTO.getPrice(),
                itemDTO.getQuantity(),
                itemDTO.getDescription()
        ));
    }

}
