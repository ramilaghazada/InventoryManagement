package org.warehouse.inventory.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.warehouse.inventory.dto.UserDto;
import org.warehouse.inventory.entity.User;
import org.warehouse.inventory.security.LoginDetails;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-20T23:18:20+0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User DtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.id() );
        user.setFullName( userDto.fullName() );
        user.setEmail( userDto.email() );
        user.setPassword( userDto.password() );

        return user;
    }

    @Override
    public UserDto UserToDto(User user) {
        if ( user == null ) {
            return null;
        }

        String id = null;
        String fullName = null;
        String email = null;
        String password = null;

        id = user.getId();
        fullName = user.getFullName();
        email = user.getEmail();
        password = user.getPassword();

        UserDto userDto = new UserDto( id, fullName, email, password );

        return userDto;
    }

    @Override
    public LoginDetails UserToLoginDetails(User user) {
        if ( user == null ) {
            return null;
        }

        String email = null;
        String password = null;

        email = user.getEmail();
        password = user.getPassword();

        LoginDetails loginDetails = new LoginDetails( email, password );

        return loginDetails;
    }
}
