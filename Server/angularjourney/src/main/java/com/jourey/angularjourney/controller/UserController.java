package com.jourey.angularjourney.controller;

import java.awt.PageAttributes.MediaType;
import java.security.Principal;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import com.jourey.angularjourney.Entity.User;
import com.jourey.angularjourney.Service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {

    @Autowired
    private LoginService loginService;
    
    @GetMapping("/welcome")
    public String welcome() {
        log.info("token : {}");
        // log.info("access user : {}", user.toString());
        return "hello ";
    }
}