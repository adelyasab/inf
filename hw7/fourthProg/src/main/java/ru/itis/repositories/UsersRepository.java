package ru.itis.repositories;

import ru.itis.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User>{
    List<User> findAllByAge(Integer age);
    boolean isExistByLoginAndPassword(String log, String pass);
    void addingUUID(String UUID, String log);
    List<User> findAllByBeginning(String s);
}
