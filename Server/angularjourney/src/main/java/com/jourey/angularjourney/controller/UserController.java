package com.jourey.angularjourney.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import com.jourey.angularjourney.Entity.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

//     @RequestMapping("/login")
//     public boolean login(@RequestBody User user) {
//     return user.getUsername().equals("user") && user.getPassword().equals("password");
//     }

//     @RequestMapping("/user")
//     public Principal user(HttpServletRequest request) {
//         String authToken = request.getHeader("Authorization")
//             .substring("Basic".length()).trim();
//             return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
//     }
}