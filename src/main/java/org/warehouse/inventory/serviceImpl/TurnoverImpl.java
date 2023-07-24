package org.warehouse.inventory.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.warehouse.inventory.dto.TurnoverDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Turnover;
import org.warehouse.inventory.exception.ItemNotFoundException;
import org.warehouse.inventory.mapper.TurnoverMapper;
import org.warehouse.inventory.repository.TurnoverRepository;
import org.warehouse.inventory.service.TurnoverService;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TurnoverImpl implements TurnoverService {

    private final TurnoverRepository repository;
    private final TurnoverMapper mapper;


    @Override
    public void add(TurnoverDto turnoverDto) {
        repository.save(mapper.DtoToTurnover(turnoverDto));
    }

    public void deleteByCard(Card card) {
        if (repository.existsByCard(card)) {
            repository.deleteByCard(card);
        } else {
            throw new ItemNotFoundException();
        }
    }

    @Override
    public TurnoverDto getByCard(Card card) {
        return repository
                .findByCard(card)
                .map(mapper::TurnoverToDto)
                .orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public List<TurnoverDto> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::TurnoverToDto)
                .toList();
    }

    protected static void CBalance(Turnover turnover){
        turnover.setCBalance(
                turnover.getOBalance() +
                turnover.getInput() -
                turnover.getOutput()
        );
    }
}
