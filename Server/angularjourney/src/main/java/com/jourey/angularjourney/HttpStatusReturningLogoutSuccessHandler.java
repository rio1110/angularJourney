package com.jourey.angularjourney;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class HttpStatusReturningLogoutSuccessHandler implements LogoutSuccessHandler {
    private final HttpStatus httpStatusToReturn;

    public HttpStatusReturningLogoutSuccessHandler() {
        this.httpStatusToReturn = HttpStatus.OK;
    }

    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException
    {
        response.setStatus(httpStatusToReturn.value());
        response.getWriter().flush();
    }
}