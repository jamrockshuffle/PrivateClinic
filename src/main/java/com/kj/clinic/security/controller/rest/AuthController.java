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
import com.kj.clinic.security.controller.jwtService.JwtHandler;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.dto.SignUpRequest;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    private final JwtHandler jwtHandler;

    @PostMapping("/token")
    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequest request) {
        LoginResponse loginResponse = service.authenticateRequest(request);
        jwtHandler.create(loginResponse.getJwt());
        return ResponseEntity.ok(loginResponse);

    }

    //spring set global variable in controller

    /*@GetMapping("/test")
    public String test(){
        return jwt;
    }*/

    @PostMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@Valid @RequestBody SignUpRequest request) {
        return ResponseEntity.ok(service.signUpUser(request));
    }

    @PostMapping("/signupnew")
    public ResponseEntity<?> createUserNoLogin(@Valid @RequestBody SignUpRequestNoLogin request) {
       // return ResponseEntity.ok(service.signUpUserNoLogin(request));

        ResponseEntity.ok(service.signUpUserNoLogin(request));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(request.getUsername());
        loginRequest.setPassword(request.getPassword());

        return ResponseEntity.ok(service.authenticateRequest(loginRequest));
    }

}