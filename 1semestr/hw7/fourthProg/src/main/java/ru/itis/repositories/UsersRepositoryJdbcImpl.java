package ru.itis.repositories;

import ru.itis.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    //language=SQL
    private final static String SQL_FIND_ALL_USERS = "select * from driver";
    //language=SQL
    private final static String SQL_FIND_ALL_USERS_BY_AGE = "select * from driver where age = ?";
    private Connection connection;
    private SimpleJdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAllByBeginning(String s) {
        return jdbcTemplate.queryForListByBeginning(SQL_FIND_ALL_USERS, usersRowMapper, s);
    }

    private RowMapper<User> usersRowMapper = row -> (User.builder()
            .id(row.getLong("id"))
            .firstname(row.getString("first_name"))
            .lastname(row.getString("last_name"))
            .age(row.getInt("age"))
            .build());

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        this.jdbcTemplate = new SimpleJdbcTemplate(connection);
    }

    @Override
    public List<User> findAllByAge(Integer age) {
        return jdbcTemplate.queryForList(SQL_FIND_ALL_USERS_BY_AGE, usersRowMapper, age);
    }

    @Override
    public boolean isExistByLoginAndPassword(String log, String pass) {
        try {
            Statement statement = connection.createStatement();
            //language=SQL
            ResultSet result = statement.executeQuery("select * from users");
            while (result.next()) {
                if ((result.getString("login").equals(log)) && (result.getString("password").equals(pass))) {
                    return true;
                }
            }
            return false;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addingUUID(String UUID, String log) {
        try {
            //language=SQL
            String sqlInsertUser = "update users SET UUID = ? where login = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertUser);
            preparedStatement.setString(1, UUID);
            preparedStatement.setString(2, log);
            System.out.println(log + " " + UUID);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.queryForList(SQL_FIND_ALL_USERS, usersRowMapper);
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteById(User entity) {

    }

    @Override
    public void update(User entity) {

    }
}
