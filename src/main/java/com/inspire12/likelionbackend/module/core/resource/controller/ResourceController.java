package com.inspire12.likelionbackend.module.core.resource.controller;


import com.inspire12.likelionbackend.module.core.resource.model.ResourceRequest;
import com.inspire12.likelionbackend.module.core.resource.service.ResourceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import lombok.RequiredArgsConstructor;

@RequestMapping("/resource")
@RestController
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @GetMapping("/load")
    public String load(String resourceName) throws IOException {
        return resourceService.load(resourceName);
    }

    @PostMapping("/write")
    public String write(@RequestBody ResourceRequest resourceRequest)  {
        throw new UnsupportedOperationException("classpath 형태에선 권장되지 않음");
    }

    @GetMapping("/load/image")
    public ResponseEntity<byte[]> loadImage() throws IOException {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resourceService.loadImage());
    }
}
