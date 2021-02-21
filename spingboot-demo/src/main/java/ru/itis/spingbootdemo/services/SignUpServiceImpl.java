package ru.itis.spingbootdemo.services;

import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.spingbootdemo.dto.UserForm;
import ru.itis.spingbootdemo.models.State;
import ru.itis.spingbootdemo.models.User;
import ru.itis.spingbootdemo.repositories.UsersRepository;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailsService mailsService;

    @Override
    public void signUp(UserForm form) {
        User newUser = User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .state(State.NOT_CONFIRMED)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        usersRepository.save(newUser);

        mailsService.sendConfirmEmail(newUser.getEmail(), newUser.getConfirmCode());
    }
}
