package org.telran.ticketapp.com.service.converter;

import org.springframework.stereotype.Component;
import org.telran.ticketapp.com.dto.UserCreateDto;
import org.telran.ticketapp.com.dto.UserDto;
import org.telran.ticketapp.com.entity.User;

@Component
public class UserConverter implements Converter<User, UserDto, UserCreateDto> {

    @Override
    public User toEntity(UserCreateDto userDto) {
        return new User(userDto.getName(), userDto.getSurname(),
                userDto.getEmail(), userDto.getPassword());
    }

    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getSurname(),
                user.getEmail());
    }
}
