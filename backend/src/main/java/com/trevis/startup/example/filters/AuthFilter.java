package com.trevis.startup.example.filters;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.exceptions.InvalidAuthAttempt;
import com.trevis.startup.example.services.AuthService;
import com.trevis.startup.example.sessions.UserSession;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {
    @Autowired
    AuthService authService;

    @Autowired
    UserSession userSession;

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
        throws
            IOException,
            ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        var auth = req.getHeader("auth");

        try {
            var decodedJWT = authService.decode(auth);
            var userId = decodedJWT.getClaim("userId").asString();

            userSession.setId(Long.valueOf(userId));
        } catch (InvalidAuthAttempt ex) {
            ((HttpServletResponse) response).setStatus(401);
            response.getOutputStream().write("Unable to authenticate.".getBytes());
            
            return;
        } catch(NoSuchAlgorithmException ex) {
            ((HttpServletResponse) response).setStatus(500);
            response.getOutputStream().write("Bad authentication configuration on the server-side.".getBytes());
            
            return;
        }

        chain.doFilter(req, res);
    }
}
