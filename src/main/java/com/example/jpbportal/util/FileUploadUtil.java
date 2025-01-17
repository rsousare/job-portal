package com.example.jpbportal.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    public static void saveFile(String uploadDir, String filename, MultipartFile multipartFile) throws Exception {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            //System.out.println("Directory does not exist. Creating: " + uploadPath);
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = multipartFile.getInputStream()){
           // System.out.println("InputStream available for file: " + filename);

            if (multipartFile.getSize() == 0) {
                throw new IOException("The file is empty: " + filename);
            }
            Path path = uploadPath.resolve(filename);
            System.out.println("FilePath " + path);
            System.out.println("filename " + filename);
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ioe) {
            throw new IOException("Could not save the file: " + filename, ioe);
        }
    }
}
