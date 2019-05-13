package com.jourey.angularjourney.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
    
    @GetMapping("/welcome")
    public String welcome() {
        log.info("token : {}");
        // log.info("access user : {}", user.toString());
        return "hello ";
    }
}