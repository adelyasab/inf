package ru.itis.spingbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.spingbootdemo.models.State;
import ru.itis.spingbootdemo.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByConfirmCode(String code);

    @Transactional
    @Modifying
    @Query("update User account set account.state = ?1 where account.id = ?2")
    int setState(State state, Long id);
}
