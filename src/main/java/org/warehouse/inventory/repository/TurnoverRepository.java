package org.warehouse.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Turnover;

import java.util.Optional;

public interface TurnoverRepository extends JpaRepository<Turnover, Card> {
    @Transactional
    Optional<Turnover> findByCard(Card card);
    Boolean existsByCard(Card card);
    @Transactional
    void deleteByCard(Card card);
}
