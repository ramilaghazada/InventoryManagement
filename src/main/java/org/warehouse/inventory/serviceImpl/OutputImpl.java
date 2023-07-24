package org.warehouse.inventory.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.warehouse.inventory.dto.OutputDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Output;
import org.warehouse.inventory.entity.Turnover;
import org.warehouse.inventory.exception.ItemNotFoundException;
import org.warehouse.inventory.mapper.OutputMapper;
import org.warehouse.inventory.repository.CardRepository;
import org.warehouse.inventory.repository.OutputRepository;
import org.warehouse.inventory.repository.TurnoverRepository;
import org.warehouse.inventory.service.OutputService;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OutputImpl implements OutputService {
    private final OutputRepository repository;
    private final CardRepository cardRepository;
    private final OutputMapper mapper;
    private final TurnoverRepository turnoverRepository;

    @Override
    public void add(OutputDto outputDto) {
        if (cardRepository.existsById(outputDto.card().getId())) {
            repository.save(mapper.DtoToOutput(outputDto));
            Card card = outputDto.card();
            Turnover turnover = turnoverRepository.findByCard(card).get();
            turnover.setOutput(turnover.getOutput() + outputDto.quantity());
            TurnoverImpl.CBalance(turnover);
            turnoverRepository.save(turnover);
        } else {
            throw new ItemNotFoundException();
        }
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {

            Output output = repository.findById(id).get();
            Card card = output.getCard();
            Turnover turnover = turnoverRepository.findByCard(card).get();
            turnover.setOutput(turnover.getOutput() - output.getQuantity());
            TurnoverImpl.CBalance(turnover);
            turnoverRepository.save(turnover);

            repository.deleteById(id);
        } else {
            throw new ItemNotFoundException();
        }
    }

    @Override
    public void update(Integer id, OutputDto outputDto) {
        Output output = mapper.DtoToOutput(outputDto);
        Output updatedOutput = repository.findById(id)
                .orElseThrow(ItemNotFoundException::new);

        Card card1 = updatedOutput.getCard();
        Turnover turnover1 = turnoverRepository.findByCard(card1).get();
        turnover1.setOutput(turnover1.getOutput() - updatedOutput.getQuantity());
        TurnoverImpl.CBalance(turnover1);
        turnoverRepository.save(turnover1);

        updatedOutput.setCard(output.getCard());
        updatedOutput.setQuantity(output.getQuantity());
        updatedOutput.setNote(output.getNote());
        repository.save(updatedOutput);

        Card card2 = updatedOutput.getCard();
        Turnover turnover2 = turnoverRepository.findByCard(card2).get();
        turnover2.setOutput(turnover2.getOutput() + updatedOutput.getQuantity());
        TurnoverImpl.CBalance(turnover2);
        turnoverRepository.save(turnover2);
    }

    @Override
    public void clear() {
        repository.deleteAll();

        List<Turnover> turnovers = turnoverRepository.findAll();
        for (Turnover tn : turnovers) {
            tn.setOutput(0.0);
            TurnoverImpl.CBalance(tn);
        }
    }

    @Override
    public OutputDto getById(Integer id) {
        return repository.findById(id)
                .map(mapper::OutputToDto)
                .orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public List<OutputDto> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::OutputToDto)
                .toList();
    }
}
