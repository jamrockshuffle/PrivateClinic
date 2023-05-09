package com.kj.clinic.security.filter;

import com.kj.clinic.security.JwtUtils;
import com.kj.clinic.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            var jwt = getToken(request);
            Optional.ofNullable(jwt).filter(jwtUtils::validateJwtToken).ifPresent(token -> {
                var username = jwtUtils.getUserNameFromJwtToken(token);
                var userDetails = userDetailsService.loadUserByUsername(username);
                var auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            });

        } catch (Exception e) {
            log.error("Cannot set user auth " + e);
        }
        filterChain.doFilter(request, response);
    }

    public String getToken(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "tkn");
        if (cookie != null) {
            return cookie.getValue();
        } else {
            var authHeader = request.getHeader("Authorization");
            return StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")
                    ? authHeader.substring(7)
                    : null;
        }
    }
}