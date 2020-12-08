package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Photosession;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class PhotosessionRepositoryImpl implements PhotosessionRepository {

    public JdbcTemplate jdbcTemplate;
    //language=SQL
    private final String SQL_SELECT_BY_ID = "select * from photosession where id=?";
    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "select * from photosession where id_user=?";
    //language=SQL
    private final String SQL_SELECT_ALL_CHEAPER = "select * from photosession where price<=?";
    //language=SQL
    private final String SQL_SELECT_ALL_TYPE = "select * from photosession where type=\'?\'";
    //language=SQL
    private final String SQL_SELECT_ALL_CHEAPER_AND_TYPE = "select * from photosession where price <= ? and type like ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from photosession";
    //language=sql
    private final String SQL_PHOTOSESSION_ID = "select nextval('photosession_id_seq')";
    //language=SQL
    private final String SQL_INSERT = "insert into photosession(id, name, type, price, id_mainphoto, id_user) values (?, ?, ?, ?, ?, ?)";
    private RowMapper<Photosession> photosessionRowMapper = (row, rowNumber) -> Photosession.builder().
            id(row.getLong("id")).
            name(row.getString("name")).
            type(row.getString("type")).
            price(row.getInt("price")).
            idMainPhoto(row.getLong("id_mainphoto")).
            idUser(row.getLong("id_user")).
            build();


    @Override
    public Optional<Photosession> getUserIdByPhotosession(Long photosessionId) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, photosessionRowMapper, photosessionId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public PhotosessionRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void update(Photosession entity) {
    }

    @Override
    public List<Photosession> getAllCheaper(int price) {
        return jdbcTemplate.query(SQL_SELECT_ALL_CHEAPER, photosessionRowMapper, price);
    }

    @Override
    public List<Photosession> getAllByUserId(Long id) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_USER_ID, photosessionRowMapper, id);
    }

    @Override
    public Long save(Photosession entity) {
        Long i = jdbcTemplate.queryForObject(SQL_PHOTOSESSION_ID, Long.class);
        jdbcTemplate.update(SQL_INSERT, i, entity.getName(), entity.getType(), entity.getPrice(), entity.getIdMainPhoto(),
                entity.getIdUser());
        return i;
    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public List<Photosession> getAllCheaperAndType(int price, String type) {
        return jdbcTemplate.query(SQL_SELECT_ALL_CHEAPER_AND_TYPE, photosessionRowMapper, price, type);
    }

    @Override
    public List<Photosession> getAllType(String type) {
        return jdbcTemplate.query(SQL_SELECT_ALL_TYPE, photosessionRowMapper,type);
    }

    @Override
    public Optional<Photosession> findById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, photosessionRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Photosession> findAll() {
        return null;
    }
}
