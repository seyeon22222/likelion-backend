package com.inspire12.likelionbackend.module.core.resource.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import lombok.RequiredArgsConstructor;

@Service
public class ResourceService {

    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    public ResourceService(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    public String load(String resourceName) throws IOException {
        // TODO /resource/file/likelion.txt 파일 문구를 리턴
        Resource resource = resourceLoader.getResource("classpath:file/likelion.txt");
        if (resource.exists()) {
            InputStream inputStream = resource.getInputStream();
            String value = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return value;
        }
        throw new FileNotFoundException(resourceName);
    }

    public byte[] loadImage() throws FileNotFoundException {
        // TODO load를 구현하신 분은 추가로 /resource/file/oh.jpg 이미지 파일 리턴을 해보세요
        Resource resource = resourceLoader.getResource("classpath:file/oh.jpg");
        if (!resource.exists())
            throw new FileNotFoundException();
        byte[] image = null;
        try {
            image = resource.getContentAsByteArray();
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        return image;
    }

}
