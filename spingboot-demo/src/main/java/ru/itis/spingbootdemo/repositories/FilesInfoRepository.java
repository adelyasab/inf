package ru.itis.spingbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.spingbootdemo.models.FileInfo;

@Repository
public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName(String storageFileName);
}
