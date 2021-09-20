package com.api.service;

import com.app.entity.Item;
import com.app.query.FindItemQuery;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class ItemQueryService {

    private final QueryGateway queryGateway;

    public CompletableFuture<Item> findById(Long itemId){
        return queryGateway.query(
                new FindItemQuery(itemId),
                ResponseTypes.instanceOf(Item.class)
        );
    }
}
