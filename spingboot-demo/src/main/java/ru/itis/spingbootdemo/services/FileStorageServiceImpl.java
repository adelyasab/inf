package ru.itis.spingbootdemo.services;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.spingbootdemo.models.FileInfo;
import ru.itis.spingbootdemo.repositories.FilesInfoRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${storage.path}")
    private String storagePath;

    @Autowired
    private FilesInfoRepository filesInfoRepository;

    @Override
    public String saveFile(MultipartFile uploadingFile) throws IOException {

        String storageName = UUID.randomUUID().toString() + "."
                + FilenameUtils.getExtension(uploadingFile.getOriginalFilename());

        FileInfo file = FileInfo.builder()
                .type(uploadingFile.getContentType())
                .size(uploadingFile.getSize())
                .originalFileName(uploadingFile.getOriginalFilename())
                .storageFileName(storageName)
                .url(storagePath + "/" + storageName)
                .build();

        Files.copy(uploadingFile.getInputStream(), Paths.get(storagePath, storageName));
        filesInfoRepository.save(file);
        return file.getStorageFileName();
    }

    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) {
        FileInfo fileInfo = filesInfoRepository.findByStorageFileName(fileName);
        response.setContentType(fileInfo.getType());
        try {
            IOUtils.copy(new FileInputStream(fileInfo.getUrl()), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
