package com.api.controller;

import com.api.service.ItemQueryService;
import com.app.entity.Item;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/item")
@Api(value = "Item Queries", description = "Item Query Events API")
@AllArgsConstructor
public class ItemQueryController {
    private final ItemQueryService itemQueryService;

    @GetMapping("/{id}")
    public CompletableFuture<Item> getItemById (@PathVariable ("id") Long itemId){
        return itemQueryService.findById(itemId);
    }
}
