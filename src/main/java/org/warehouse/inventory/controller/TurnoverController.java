package org.warehouse.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.warehouse.inventory.dto.TurnoverDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.serviceImpl.TurnoverImpl;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/turnover")
@RequiredArgsConstructor
public class TurnoverController {
    private final TurnoverImpl impl;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TurnoverDto> getAll(){
        return impl.getAll();
    }

    @GetMapping("/{card}")
    @ResponseStatus(HttpStatus.OK)
    public TurnoverDto getByCard(@PathVariable("card") Card card){
        return impl.getByCard(card);
    }

}
