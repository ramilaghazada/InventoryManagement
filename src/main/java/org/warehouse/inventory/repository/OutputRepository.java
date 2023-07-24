package org.warehouse.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.warehouse.inventory.entity.Output;

public interface OutputRepository extends JpaRepository<Output, Integer> {
}
