package org.warehouse.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.warehouse.inventory.entity.Card;
import org.warehouse.inventory.entity.Input;
import org.warehouse.inventory.entity.Turnover;

import java.util.Optional;

public interface InputRepository extends JpaRepository<Input, Integer> {}
