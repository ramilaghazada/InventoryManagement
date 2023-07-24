package org.warehouse.inventory.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.warehouse.inventory.dto.UserDto;
import org.warehouse.inventory.entity.User;
import org.warehouse.inventory.exception.ItemExistsException;
import org.warehouse.inventory.exception.ItemNotFoundException;
import org.warehouse.inventory.mapper.UserMapper;
import org.warehouse.inventory.repository.UserRepository;
import org.warehouse.inventory.service.UserService;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public void add(UserDto userDto) {
        if (!repository.existsById(userDto.id())) {
            repository.save(mapper.DtoToUser(userDto));
        } else {
            throw new ItemExistsException();
        }
    }

    @Override
    public void delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ItemNotFoundException();
        }
    }

    @Override
    public void update(String id, UserDto userDto) {
        User user = mapper.DtoToUser(userDto);
        User updatedUser = repository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        updatedUser.setFullName(user.getFullName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        repository.save(updatedUser);
    }

    @Override
    public void clear() {
        repository.deleteAll();

    }

    @Override
    public UserDto getById(String id) {
        return repository.findById(id)
                .map(mapper::UserToDto)
                .orElseThrow(
                        ItemNotFoundException::new);
    }

    @Override
    public List<UserDto> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::UserToDto)
                .toList();
    }
}
