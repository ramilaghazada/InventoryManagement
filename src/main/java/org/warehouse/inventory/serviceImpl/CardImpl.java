package org.warehouse.inventory.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.warehouse.inventory.dto.CardDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Turnover;
import org.warehouse.inventory.exception.ItemExistsException;
import org.warehouse.inventory.exception.ItemHasTurnoverException;
import org.warehouse.inventory.exception.ItemNotFoundException;
import org.warehouse.inventory.mapper.CardMapper;
import org.warehouse.inventory.repository.*;
import org.warehouse.inventory.service.CardService;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CardImpl implements CardService {
    private final CardRepository repository;
    private final CardMapper mapper;

    private final InputRepository inputRepository;
    private final OutputRepository outputRepository;
    private final OBalanceRepository oBalanceRepository;
    private final TurnoverRepository turnoverRepository;

    @Override
    public void add(CardDto cardDto) {
        if (!repository.existsById(cardDto.id())) {
            repository.save(mapper.DtoToCard(cardDto));
            Card card = repository.findById(cardDto.id()).get();
            Turnover turnover = new Turnover();
            turnover.setCard(card);
            turnover.setOBalance(0.0);
            turnover.setInput(0.0);
            turnover.setOutput(0.0);
            turnover.setCBalance(0.0);
            turnoverRepository.save(turnover);
        } else {
            throw new ItemExistsException();
        }
    }

    @Override
    public void delete(String id) {
        if (repository.existsById(id)) {
            Card card = repository.findById(id).get();
            Turnover turnover = turnoverRepository.findByCard(card).get();
            if(turnover.getOBalance() == 0 &&
            turnover.getInput() == 0 &&
            turnover.getOutput() == 0) {
                turnoverRepository.deleteByCard(card);
                repository.deleteById(id);
            } else {
                throw new ItemHasTurnoverException();
            }
        } else {
            throw new ItemNotFoundException();
        }
    }

    @Override
    public void update(String id, CardDto cardDto) {
        Card baseCard = mapper.DtoToCard(cardDto);
        Card updatedCard = repository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        updatedCard.setDescription(baseCard.getDescription());
        updatedCard.setUnit(baseCard.getUnit());
        repository.save(updatedCard);
    }

    @Override
    public void clear() {
        inputRepository.deleteAll();
        oBalanceRepository.deleteAll();
        outputRepository.deleteAll();
        turnoverRepository.deleteAll();
        repository.deleteAll();

    }

    @Override
    public CardDto getById(String id) {
        return repository.findById(id)
                .map(mapper::CardToDto)
                .orElseThrow(
                        ItemNotFoundException::new);
    }

    @Override
    public List<CardDto> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::CardToDto)
                .toList();
    }
}
