package ru.itis.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.dto.UserForm;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

public class SignUpServiceImpl implements SignUpService{
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(UserForm userForm) {
        User user = User.builder().email(userForm.getEmail()).
                lastname(userForm.getLastName()).
                firstname(userForm.getFirstName()).
                hashPassword(passwordEncoder.encode(userForm.getPassword())).
                mainPhotoId(userForm.getMainPhotoId()).
                build();
        usersRepository.save(user);
    }
}
