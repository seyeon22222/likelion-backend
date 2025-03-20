package com.inspire12.likelionbackend.controller.core;

import com.inspire12.likelionbackend.service.core.EnvApplicationPlaygroundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EnvApplicationController {
    private final EnvApplicationPlaygroundService envApplicationPlaygroundService;

    @GetMapping("/env")
    public String geApplicationEnv() {
        return envApplicationPlaygroundService.hello();
    }
}
