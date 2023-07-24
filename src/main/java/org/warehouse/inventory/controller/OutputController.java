package org.warehouse.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.warehouse.inventory.dto.OutputDto;
import org.warehouse.inventory.serviceImpl.OutputImpl;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/output")
@RequiredArgsConstructor
public class OutputController {

    private final OutputImpl impl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Validated OutputDto outputDto) {
        impl.add(outputDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Integer id) {
        impl.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Integer id,
                       @RequestBody @Validated OutputDto outputDto) {
        impl.update(id, outputDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void clear() {
        impl.clear();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public OutputDto getById(@PathVariable("id") Integer id) {
        return impl.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OutputDto> getAll() {
        return impl.getAll();
    }
}
