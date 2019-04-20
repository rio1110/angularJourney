package com.jourey.angularjourney.controller;

import java.awt.PageAttributes.MediaType;
import java.security.Principal;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import com.jourey.angularjourney.Entity.User;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "user")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {

    @GetMapping
    public String greeting(@AuthenticationPrincipal(expression = "user") User user, CsrfToken csrfToken) {
        log.info("token : {}", csrfToken.getToken());
        log.info("access user : {}", user.toString());
        return "hello " + user.getUsername();
    }

    @GetMapping(path = "echo/{message}")
    public String getEcho(@PathVariable(name = "message") String message) {
        return message.toUpperCase();
    }
}