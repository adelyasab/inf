package ru.itis.spingbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spingbootdemo.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
