package com.inspire12.likelionbackend.module.core.threadlocal.filter;

import com.inspire12.likelionbackend.module.core.threadlocal.context.UserContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class AuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO
        String header = request.getHeader("X-USER-NAME");
        log.info("UserContextHolder before : {}", UserContextHolder.getUser());
        UserContextHolder.setUser(header);
        log.info("UserContextHolder after : {}", UserContextHolder.getUser());
        try {
            filterChain.doFilter(request, response);
        } finally {
            UserContextHolder.clear();
        }
    }
}