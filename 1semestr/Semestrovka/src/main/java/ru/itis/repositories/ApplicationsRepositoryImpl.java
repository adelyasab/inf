package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Application;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ApplicationsRepositoryImpl implements ApplicationsRepository{
    public JdbcTemplate jdbcTemplate;
     //language=SQL
    private final String SQL_SELECT_ALL_CUST_ID = "select * from applications where customer_id=?";
    //language=SQL
    private final String SQL_ALL_CUST_WHOM = "select * from applications where photosession_by_user_id=?";
    //language=SQL
    private final String SQL_ALL = "select * from applications";
    //language=SQL
    private final String SQL_INSERT = "insert into applications(date, time, customer_id, photosession_id, phonenumber, name, photosession_by_user_id)" +
            " values (?, ?, ?, ?, ?, ?, ?)";
    private RowMapper<Application> applicationRowMapper = (row, rowNumber)  -> Application.builder().
            name(row.getString("name")).
            phoneNumber(row.getString("phonenumber")).
            date(row.getString("date")).
            time(row.getString("time")).
            id(row.getLong("id")).
            customerId(row.getLong("customer_id")).
            photosessionId(row.getLong("photosession_id")).
            build();

    public ApplicationsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void update(Application entity) {

    }

    @Override
    public Long save(Application entity) {
        jdbcTemplate.update(SQL_INSERT, entity.getDate(), entity.getTime(),
                entity.getCustomerId(), entity.getPhotosessionId(), entity.getPhoneNumber(),
                entity.getName(), entity.getPhotosessionByUserId());
        return 0L;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Application> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Application> findAll() {
        return null;
    }

    @Override
    public List<Application> findByCustomer(Long id) {
        return jdbcTemplate.query(SQL_SELECT_ALL_CUST_ID, applicationRowMapper, id);
    }

    @Override
    public List<Application> getAll() {
        return jdbcTemplate.query(SQL_ALL, applicationRowMapper);
    }

    @Override
    public List<Application> findByWhomCustomer(Long id) {
        return jdbcTemplate.query(SQL_ALL_CUST_WHOM, applicationRowMapper, id);
    }
}
