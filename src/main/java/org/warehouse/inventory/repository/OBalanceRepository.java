package org.warehouse.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.warehouse.inventory.entity.OBalance;

public interface OBalanceRepository extends JpaRepository<OBalance, Integer> {
}
