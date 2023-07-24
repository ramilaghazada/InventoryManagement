package org.warehouse.inventory.security;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.warehouse.inventory.entity.User;
import org.warehouse.inventory.exception.ItemNotFoundException;
import org.warehouse.inventory.mapper.UserMapper;
import org.warehouse.inventory.repository.UserRepository;

@AllArgsConstructor
@Service
public class LoginDetailsService implements UserDetailsService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public LoginDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("load user by username stated");
        User user = repository
                .findUserByEmail(email)
                .orElseThrow(ItemNotFoundException::new);
        System.out.println(user);
        return mapper.UserToLoginDetails(user);
    }
}
