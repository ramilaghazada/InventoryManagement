package org.warehouse.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.warehouse.inventory.dto.CardDto;
import org.warehouse.inventory.serviceImpl.CardImpl;

import java.util.List;

@RestController
@RestControllerAdvice
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {

    private final CardImpl impl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Validated CardDto cardDto) {
        impl.add(cardDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") String id) {
        impl.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id,
                       @RequestBody @Validated CardDto cardDto) {
        impl.update(id, cardDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void clear() {
        impl.clear();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CardDto getById(@PathVariable("id") String id) {
        return impl.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CardDto> getAll() {
        return impl.getAll();
    }
}
