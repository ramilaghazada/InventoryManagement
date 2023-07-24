package org.warehouse.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.warehouse.inventory.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByEmail(String email);
}
