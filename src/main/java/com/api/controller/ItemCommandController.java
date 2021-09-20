package com.api.controller;

import com.api.dto.ItemDTO;
import com.api.service.ItemCommandService;
import com.app.entity.Item;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/item")
@Api(value = "Item Commands", description = "Item Commands API")
@AllArgsConstructor
public class ItemCommandController {

    private final ItemCommandService itemCommandService;

    @PostMapping
    @ResponseStatus(value = CREATED)
    public CompletableFuture<Item> addItem(@RequestBody ItemDTO itemDTO){
        return itemCommandService.addItem(itemDTO);
    }
}
