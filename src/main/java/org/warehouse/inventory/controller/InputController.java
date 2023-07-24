package org.warehouse.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.warehouse.inventory.dto.InputDto;
import org.warehouse.inventory.serviceImpl.InputImpl;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/input")
@RequiredArgsConstructor
public class InputController {

    private final InputImpl impl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Validated InputDto inputDto) {
        impl.add(inputDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Integer id) {
        impl.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Integer id,
                       @RequestBody @Validated InputDto inputDto) {
        impl.update(id, inputDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void clear() {
        impl.clear();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public InputDto getById(@PathVariable("id") Integer id) {
        return impl.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InputDto> getAll() {
        return impl.getAll();
    }
}
