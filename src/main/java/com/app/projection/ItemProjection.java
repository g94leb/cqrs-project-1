package com.app.projection;

import com.app.entity.Item;
import com.app.event.ItemCreatedEvent;
import com.app.query.FindItemQuery;
import com.app.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ItemProjection {

    private final ItemRepository itemRepository;

    @EventHandler
    public void on(ItemCreatedEvent event) {
        log.debug("Handling an Item creation command {}", event.getItemId());
        Item item = new Item(event.getItemId(),
                event.getPrice(),
                event.getQuantity(),
                event.getDescription()
        );
        itemRepository.save(item);
    }

    @QueryHandler
    public Item handle(FindItemQuery query) {
        log.debug("Handling Find Item Query : {}", query);
        return itemRepository.findById(query.getItemId()).orElse(null);
    }

}
