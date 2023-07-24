package org.warehouse.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.warehouse.inventory.dto.OBalanceDto;
import org.warehouse.inventory.serviceImpl.OBalanceImpl;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/OBalance")
@RequiredArgsConstructor
public class OBalanceController {

    private final OBalanceImpl impl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Validated OBalanceDto oBalanceDto) {
        impl.add(oBalanceDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Integer id) {
        impl.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Integer id,
                       @RequestBody @Validated OBalanceDto oBalanceDto) {
        impl.update(id, oBalanceDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void clear() {
        impl.clear();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public OBalanceDto getById(@PathVariable("id") Integer id) {
        return impl.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OBalanceDto> getAll() {
        return impl.getAll();
    }
}
