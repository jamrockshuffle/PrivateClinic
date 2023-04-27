/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.04.23, 12:37
 *  * @Version: AuthUIController: 1.0
 *
 */

package com.kj.clinic.security.controller.ui;

import com.kj.clinic.security.AuthService;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.SignUpRequest;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthUIController {

    private final AuthService service;

    @GetMapping("/signup")
    public String create(Model model){

        SignUpRequestNoLogin request = new SignUpRequestNoLogin();
        request.setUsername("");
        request.setPassword("");

        model.addAttribute("request", request);


        return "signUpFront";
    }

    @PostMapping("/signup")
    public String create(Model model, @ModelAttribute("request") SignUpRequestNoLogin request){

        ResponseEntity.ok(service.signUpUserNoLogin(request));

        return "redirect:/";
    }
}
