package com.sukhoverka.dao;


import com.sun.jersey.core.header.FormDataContentDisposition;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Component
public class ImageDao {

    private Map<Integer, String> images = new HashMap<Integer, String>();

    public void saveUserLogo(int userId, InputStream uploadedImage, FormDataContentDisposition metaInfo) {
        File tempDir = createTempDir();
        File tempFile = createTempFile(uploadedImage, metaInfo.getFileName(), tempDir);
        if (tempFile != null) {
            images.put(userId, tempFile.getAbsolutePath());
        }
    }


    private File createTempDir() {
        File tempDir = null;
        try {
            tempDir = File.createTempFile("rest-image", "");
            tempDir.delete();
            if (!tempDir.mkdir()) {
                throw new IOException("Could not create temp directory:  " + tempDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempDir;
    }

    private File createTempFile(InputStream inputStream, String fileName, File tempDir) {
        try {
            File tempFile = new File(tempDir, fileName);
            Files.copy(inputStream, tempFile.toPath());
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getUserLogo(int userId) {
        return images.get(userId);
    }


}
