package org.warehouse.inventory.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.warehouse.inventory.dto.InputDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Input;
import org.warehouse.inventory.entity.Turnover;
import org.warehouse.inventory.exception.ItemNotFoundException;
import org.warehouse.inventory.mapper.InputMapper;
import org.warehouse.inventory.repository.CardRepository;
import org.warehouse.inventory.repository.InputRepository;
import org.warehouse.inventory.repository.TurnoverRepository;
import org.warehouse.inventory.service.InputService;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InputImpl implements InputService {
    private final CardRepository cardRepository;
    private final InputRepository repository;
    private final TurnoverRepository turnoverRepository;
    private final InputMapper mapper;

    @Override
    public void add(InputDto inputDto) {
        if(cardRepository.existsById(inputDto.card().getId())) {
            repository.save(mapper.DtoToInput(inputDto));

            Card card = inputDto.card();
            Turnover turnover = turnoverRepository.findByCard(card).get();
            turnover.setInput(turnover.getInput() + inputDto.quantity());
            TurnoverImpl.CBalance(turnover);
            turnoverRepository.save(turnover);

        } else {
            throw new ItemNotFoundException();
        }
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {

            Input input = repository.findById(id).get();
            Card card = input.getCard();
            Turnover turnover = turnoverRepository.findByCard(card).get();
            turnover.setInput(turnover.getInput() - input.getQuantity());
            TurnoverImpl.CBalance(turnover);
            turnoverRepository.save(turnover);

            repository.deleteById(id);
        } else {
            throw new ItemNotFoundException();
        }
    }

    @Override
    public void update(Integer id, InputDto inputDto) {

        Input input = mapper.DtoToInput(inputDto);
        Input updatedInput = repository.findById(id)
                .orElseThrow(ItemNotFoundException::new);

        Card card1 = updatedInput.getCard();
        Turnover turnover1 = turnoverRepository.findByCard(card1).get();
        turnover1.setInput(turnover1.getInput() - updatedInput.getQuantity());
        TurnoverImpl.CBalance(turnover1);
        turnoverRepository.save(turnover1);

        updatedInput.setCard(input.getCard());
        updatedInput.setQuantity(input.getQuantity());
        updatedInput.setNote(input.getNote());
        repository.save(updatedInput);

        Card card2 = updatedInput.getCard();
        Turnover turnover2 = turnoverRepository.findByCard(card2).get();
        turnover2.setInput(turnover2.getInput() + updatedInput.getQuantity());
        TurnoverImpl.CBalance(turnover2);
        turnoverRepository.save(turnover2);
    }

    @Override
    public void clear() {
        repository.deleteAll();

        List<Turnover> turnovers = turnoverRepository.findAll();
        for (Turnover tn : turnovers) {
            tn.setInput(0.0);
            TurnoverImpl.CBalance(tn);
            turnoverRepository.save(tn);
        }
    }

    @Override
    public InputDto getById(Integer id) {
        return repository.findById(id)
                .map(mapper::InputToDto)
                .orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public List<InputDto> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::InputToDto)
                .toList();
    }
}
