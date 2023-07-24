package org.warehouse.inventory.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.warehouse.inventory.dto.OBalanceDto;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Input;
import org.warehouse.inventory.entity.OBalance;
import org.warehouse.inventory.entity.Turnover;
import org.warehouse.inventory.exception.ItemNotFoundException;
import org.warehouse.inventory.mapper.OBalanceMapper;
import org.warehouse.inventory.repository.CardRepository;
import org.warehouse.inventory.repository.OBalanceRepository;
import org.warehouse.inventory.repository.TurnoverRepository;
import org.warehouse.inventory.service.OBalanceService;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OBalanceImpl implements OBalanceService {
    private final OBalanceRepository repository;
    private final CardRepository cardRepository;
    private final OBalanceMapper mapper;
    private final TurnoverRepository turnoverRepository;

    @Override
    public void add(OBalanceDto oBalanceDto) {
        if (cardRepository.existsById(oBalanceDto.card().getId())) {
            repository.save(mapper.DtoToOBalance(oBalanceDto));

            Card card = oBalanceDto.card();
            Turnover turnover = turnoverRepository.findByCard(card).get();
            turnover.setOBalance(turnover.getOBalance() + oBalanceDto.quantity());
            TurnoverImpl.CBalance(turnover);

            turnoverRepository.save(turnover);
        } else {
            throw new ItemNotFoundException();
        }
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {

            OBalance oBalance = repository.findById(id).get();
            Card card = oBalance.getCard();
            Turnover turnover = turnoverRepository.findByCard(card).get();
            turnover.setCBalance(turnover.getOBalance() - oBalance.getQuantity());
            TurnoverImpl.CBalance(turnover);
            turnoverRepository.save(turnover);

            repository.deleteById(id);
        } else {
            throw new ItemNotFoundException();
        }
    }

    @Override
    public void update(Integer id, OBalanceDto oBalanceDto) {
        OBalance oBalance = mapper.DtoToOBalance(oBalanceDto);
        OBalance updatedBalance = repository.findById(id)
                .orElseThrow(ItemNotFoundException::new);

        Card card1 = updatedBalance.getCard();
        Turnover turnover1 = turnoverRepository.findByCard(card1).get();
        turnover1.setOBalance(turnover1.getOBalance() - updatedBalance.getQuantity());
        TurnoverImpl.CBalance(turnover1);
        turnoverRepository.save(turnover1);

        updatedBalance.setCard(oBalance.getCard());
        updatedBalance.setQuantity(oBalance.getQuantity());

        Card card2 = updatedBalance.getCard();
        Turnover turnover2 = turnoverRepository.findByCard(card2).get();
        turnover2.setOBalance(turnover2.getOBalance() + updatedBalance.getQuantity());
        TurnoverImpl.CBalance(turnover2);
        turnoverRepository.save(turnover2);

        repository.save(updatedBalance);
    }

    @Override
    public void clear() {
        repository.deleteAll();

        List<Turnover> turnovers = turnoverRepository.findAll();
        for (Turnover tn : turnovers) {
            tn.setOBalance(0.0);
            TurnoverImpl.CBalance(tn);
        }
    }

    @Override
    public OBalanceDto getById(Integer id) {
        return repository.findById(id)
                .map(mapper::OBalanceToDto)
                .orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public List<OBalanceDto> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::OBalanceToDto)
                .toList();
    }
}
