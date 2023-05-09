/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.04.23, 12:37
 *  * @Version: AuthController: 1.0
 *
 */

package com.kj.clinic.security.controller.rest;

import com.kj.clinic.security.AuthService;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.dto.SignUpRequest;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@SessionScope
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/token")
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequest request, HttpServletResponse response) {
        LoginResponse loginResponse = service.authenticateRequest(request);

        response.addHeader("Authorization", "Bearer " + loginResponse.getJwt());

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@Valid @RequestBody SignUpRequest request) {
        return ResponseEntity.ok(service.signUpUser(request));
    }

    /*@PostMapping("/signupnew")
    public ResponseEntity<?> createUserNoLogin(@Valid @RequestBody SignUpRequestNoLogin request) {
       // return ResponseEntity.ok(service.signUpUserNoLogin(request));

        ResponseEntity.ok(service.signUpUserNoLogin(request));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(request.getUsername());
        loginRequest.setPassword(request.getPassword());

        return ResponseEntity.ok(service.authenticateRequest(loginRequest));
    }*/

}