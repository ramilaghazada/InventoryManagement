package org.warehouse.inventory.mapper;

import org.mapstruct.Mapper;
import org.warehouse.inventory.dto.UserDto;
import org.warehouse.inventory.entity.User;
import org.warehouse.inventory.security.LoginDetails;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User DtoToUser(UserDto userDto);

    UserDto UserToDto(User user);

    LoginDetails UserToLoginDetails(User user);
}
