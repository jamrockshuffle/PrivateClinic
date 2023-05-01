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
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.dto.SignUpRequest;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class AuthUIController {

    private final AuthService service;

    @GetMapping("/signup")
    public String createAccount(Model model){

        SignUpRequestNoLogin request = new SignUpRequestNoLogin();
        request.setUsername("");
        request.setPassword("");

        model.addAttribute("request", request);


        return "signUpFront";
    }

    @PostMapping("/signup")
    public String createAccount(Model model, @ModelAttribute("request") SignUpRequestNoLogin request){

        ResponseEntity.ok(service.signUpUserNoLogin(request));

        return "redirect:/";
    }

    @GetMapping("/login")
    public String logIn(Model model){

        LoginRequest request = new LoginRequest();
        request.setUsername("");
        request.setPassword("");

        model.addAttribute("request", request);

        return "logInFront";
    }

    /*@PostMapping("/login")
    public String logIn(Model model,
                          @ModelAttribute("request") LoginRequest request){

        LoginResponse response = service.authenticateRequest(request);

        ResponseEntity.ok(response);

        model.addAttribute("response", response);

        *//*redirectAttributes.addFlashAttribute("loginResponse", response);*//*

        *//*        return "forward:/";*//*
        return "redirect:/";
    }*/

    @PostMapping("/login")
    public String logIn(Model model,
                        @ModelAttribute("request") LoginRequest request,
                        final RedirectAttributes redirectAttributes){

        LoginResponse response = service.authenticateRequest(request);

        ResponseEntity.ok(response);

        redirectAttributes.addFlashAttribute("response", response);

        return "redirect:/process";
    }


    @GetMapping("/process")
    public String process(Model model,
                          @ModelAttribute("response") LoginResponse response,
                          final RedirectAttributes redirectAttributes,
                          HttpServletResponse servletResponse){

        /*Cookie cookie = new Cookie("name", response.getJwt());

        cookie.setSecure(true);
        cookie.setMaxAge(3600000);

        servletResponse.addCookie(cookie);*/

        servletResponse.addHeader("Set-Cookie", "name=Bearer " + response.getJwt() + ";");
        // servletResponse.addHeader("Set-Cookie", "access-token=" + response.getJwt() + "; Secure; HttpOnly");

        return "process";
    }

    @PostMapping("/process")
    public String process(Model model,
                          @ModelAttribute("response") LoginResponse response,
                          HttpServletResponse servletResponse){

        return "redirect:/";
    }

}
