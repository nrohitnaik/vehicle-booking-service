package com.car.booking.mapper;

import com.car.booking.controller.dto.UserDto;
import com.car.booking.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto userToUserDto(User user);
}
