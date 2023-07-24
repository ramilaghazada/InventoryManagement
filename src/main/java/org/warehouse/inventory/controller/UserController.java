package org.warehouse.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.warehouse.inventory.dto.UserDto;
import org.warehouse.inventory.serviceImpl.UserImpl;

import java.util.List;

@RestController
@RestControllerAdvice
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserImpl impl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Validated UserDto userDto) {
        impl.add(userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") String id) {
        impl.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id,
                       @RequestBody @Validated UserDto userDto) {
        impl.update(id, userDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void clear() {
        impl.clear();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getById(@PathVariable("id") String id) {
        return impl.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAll() {
        return impl.getAll();
    }
}
