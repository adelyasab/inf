package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Photo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class PhotoRepositoryImpl implements PhotoRepository{

    public JdbcTemplate jdbcTemplate;
    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM photos WHERE id=?";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from photos";
    //language=sql
    private final String SQL_PHOTOS_ID = "select nextval('photos_id_seq')";
    //language=SQL
    private final String SQL_INSERT = "insert into photos(id, storage_filename, original_filename, type, size, id_photosession) values (?, ?, ?, ?, ?, ?)";
    //language=SQL
    private final String SQL_UPDATE = "update photos set id_photosession=? where id=?";

    private RowMapper<Photo> photoRowMapper = (row, rowNumber)  -> Photo.builder().
            id(row.getLong("id")).
            originFileName(row.getString("original_filename")).
            storageFileName(row.getString("storage_filename")).
            type(row.getString("type")).
            size(row.getLong("size")).
            idPhotosession(row.getLong("id_photosession")).
            build();

    public PhotoRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void update(Photo entity) {
    }

    @Override
    public Long save(Photo entity) {
        Long i = jdbcTemplate.queryForObject(SQL_PHOTOS_ID, Long.class);
        jdbcTemplate.update(SQL_INSERT, i, entity.getStorageFileName(), entity.getOriginFileName(), entity.getType(), entity.getSize(),
                entity.getIdPhotosession());
        return i;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Photo> findById(Long id) {
        System.out.println(id);
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, photoRowMapper, id));
    }

    @Override
    public List<Photo> findAll() {
        return null;
    }

    @Override
    public void changingPhotosessionById(Long id, Long photoset_id) {
        jdbcTemplate.update(SQL_UPDATE, photoset_id, id);
    }
}
