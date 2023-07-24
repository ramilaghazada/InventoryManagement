package org.warehouse.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.warehouse.inventory.entity.Card;

public interface CardRepository extends JpaRepository<Card, String> {
}
