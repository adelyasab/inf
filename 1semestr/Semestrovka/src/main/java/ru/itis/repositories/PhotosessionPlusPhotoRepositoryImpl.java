package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.PhotosessionPlusPhoto;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class PhotosessionPlusPhotoRepositoryImpl implements PhotosessionPlusPhotoRepository{
    public JdbcTemplate jdbcTemplate;
    //language=SQL
    private final String SQL_ALL = "select * from photosessions_plus_photos";
    //language=SQL
    private final String SQL_INSERT = "insert into photosessions_plus_photos(photosession_id, storage_name, type)" +
            " values (?, ?, ?)";
    private RowMapper<PhotosessionPlusPhoto> photosessionPlusPhotoRowMapper = (row, rowNumber)  -> PhotosessionPlusPhoto.builder().
            idPhotoset(row.getLong("photosession_id")).
            storageName(row.getString("storage_name")).
            type(row.getString("type")).
            build();

    public PhotosessionPlusPhotoRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void update(PhotosessionPlusPhoto entity) {

    }

    @Override
    public Long save(PhotosessionPlusPhoto entity) {
        jdbcTemplate.update(SQL_INSERT, entity.getIdPhotoset(), entity.getStorageName(), entity.getType());
        return 0L;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<PhotosessionPlusPhoto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PhotosessionPlusPhoto> findAll() {
        return jdbcTemplate.query(SQL_ALL, photosessionPlusPhotoRowMapper);
    }
}
