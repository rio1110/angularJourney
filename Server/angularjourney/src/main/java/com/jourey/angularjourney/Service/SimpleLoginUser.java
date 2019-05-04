package com.jourey.angularjourney.Service;

import java.util.List;

import com.jourey.angularjourney.Entity.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

// public class SimpleLoginUser extends org.springframework.security.core.userdetails.User {
public class SimpleLoginUser {
    // // Userエンティティ
    // private User user;

    // public User getUser() {
    //     return user;
    // }

    // public SimpleLoginUser(User user) {
    //     super(user.getUsername(), user.getPassword(), determineRoles(user.getAdmin_flag()));
    //     this.user = user;
    // }

    // private static final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER");
    // private static final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");

    // private static List<GrantedAuthority> determineRoles(boolean isAdmin) {
    //     return isAdmin ? ADMIN_ROLES : USER_ROLES;
    // }
}