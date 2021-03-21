package ru.itis.spingbootdemo.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.spingbootdemo.models.User;
import ru.itis.spingbootdemo.repositories.UsersRepository;

import java.util.Optional;

@Component("customUserDetailsService")
public class UsersDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.findByEmail(email);
        if (user.isPresent()) {
            return new UserDetailsImpl(user.get());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
