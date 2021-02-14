package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository{

    public JdbcTemplate jdbcTemplate;
    //language=SQL
    private final String SQL_SELECT_BY_EMAIL = "select * from users where email = ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from users";
    //language=SQL
    private final String SQL_INSERT = "insert into users(email, first_name, last_name, hash_password, main_photo_id)" +
            " values (?, ?, ?, ?, ?)";
    private RowMapper<User> userRowMapper = (row, rowNumber)  -> User.builder().
                id(row.getLong("id")).
                firstname(row.getString("first_name")).
                lastname(row.getString("last_name")).
                email(row.getString("email")).
                hashPassword(row.getString("hash_password")).
                mainPhotoId(row.getLong("main_photo_id")).
                build();

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, userRowMapper, email));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Long save(User entity) {
        jdbcTemplate.update(SQL_INSERT, entity.getEmail(), entity.getFirstname(),
                entity.getLastname(), entity.getHashPassword(), entity.getMainPhotoId());
        return 0l;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }
}