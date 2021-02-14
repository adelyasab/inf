package ru.itis.spingbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spingbootdemo.dto.UserDto;
import ru.itis.spingbootdemo.models.User;
import ru.itis.spingbootdemo.repositories.UsersRepository;

import java.util.List;

import static ru.itis.spingbootdemo.dto.UserDto.from;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepository.findAll();
        return from(users);
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(usersRepository.findById(userId).orElse(User.builder().build()));
    }
}
