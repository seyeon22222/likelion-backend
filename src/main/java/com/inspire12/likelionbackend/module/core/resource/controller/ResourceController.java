package com.inspire12.likelionbackend.module.core.resource.controller;


import com.inspire12.likelionbackend.module.core.resource.service.ResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/load")
@RestController
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public String load(String resourceName) throws IOException {
        return resourceService.load(resourceName);
    }
}
