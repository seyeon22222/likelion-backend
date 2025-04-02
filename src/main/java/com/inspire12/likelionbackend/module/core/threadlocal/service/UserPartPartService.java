package com.inspire12.likelionbackend.module.core.threadlocal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserPartPartService {
    private static Logger log = LoggerFactory.getLogger(UserPartPartService.class);
    public String useCurrentUsername() {

        String username = "FIX ME";
        log.info("username : {}", username);
        return username;
    }
}
