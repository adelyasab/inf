package ru.itis.spingbootdemo.services;

import ru.itis.spingbootdemo.dto.UserDto;

import java.util.List;

public interface UsersService {
    public List<UserDto> getAllUsers();

    UserDto getUser(Long userId);

    void confirmUserWithCode(String code);

    String getNameByCode(String code);
}
