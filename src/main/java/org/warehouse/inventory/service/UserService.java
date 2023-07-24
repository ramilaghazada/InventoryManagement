package org.warehouse.inventory.service;

import org.warehouse.inventory.dto.UserDto;

import java.util.List;

public interface UserService {

    void add(UserDto userDto);

    void delete(String id);

    void update(String id, UserDto userDto);

    void clear();

    UserDto getById(String id);

    List<UserDto> getAll();
}
