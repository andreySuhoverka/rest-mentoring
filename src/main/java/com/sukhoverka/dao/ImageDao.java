package com.sukhoverka.dao;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class ImageDao {

    private Map<Integer, byte[]> images = new HashMap<Integer, byte[]>();

    public void saveUserLogo(int userId, InputStream uploadedImage) {
        try {
            byte[] logoBytes = new byte[1024 * 1024 * 10];
            uploadedImage.read(logoBytes);
            images.put(userId, logoBytes);
        } catch (IOException e) {
            throw new RuntimeException("cant save user logo", e);
        }
    }

    public byte[] getUserLogo(int userId) {
        return images.get(userId);
    }


}
