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

    @GetMapping("/signUp")
    public String createAccount(Model model,
                                SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/";
        } else {
            SignUpRequestNoLogin request = new SignUpRequestNoLogin();
            request.setUsername("");
            request.setPassword("");

            model.addAttribute("request", request);

            return "account/signUpFront";
        }
    }

    @PostMapping("/signUp")
    public String createAccount(Model model,
                                @ModelAttribute("request") SignUpRequestNoLogin request,
                                HttpServletResponse servletResponse){

        ResponseEntity.ok(service.signUpUserNoLogin(request));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(request.getUsername());
        loginRequest.setPassword(request.getPassword());

        LoginResponse response = service.authenticateRequest(loginRequest);

        //secure
        // servletResponse.addHeader("Set-Cookie", "access-token=" + response.getJwt() + "; Secure; HttpOnly");

        Cookie cookie = new Cookie("tkn", response.getJwt());

        servletResponse.addCookie(cookie);

        return "redirect:/";
    }

    @GetMapping("/logIn")
    public String logIn(Model model,
                        SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/";
        } else {
            LoginRequest request = new LoginRequest();
            request.setUsername("");
            request.setPassword("");

            model.addAttribute("request", request);

            return "account/log-in";
        }
    }

    @PostMapping("/logIn")
    public String logIn(Model model,
                          @ModelAttribute("request") LoginRequest request,
                        HttpServletResponse servletResponse){

            LoginResponse response = service.authenticateRequest(request);
            ResponseEntity.ok(response);

            //secure
            // servletResponse.addHeader("Set-Cookie", "access-token=" + response.getJwt() + "; Secure; HttpOnly");

            Cookie cookie = new Cookie("tkn", response.getJwt());

            servletResponse.addCookie(cookie);

            return "redirect:/";
    }

    @GetMapping("/logOut")
    public String logOut(Model model,
                         HttpServletResponse response,
                         HttpServletRequest request){

        Cookie cookie = new Cookie("tkn", null);
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){

        return "redirect:/logIn";
    }

    @GetMapping("/logout")
    public String logout(){

        return "redirect:/logOut";
    }

    /*@PostMapping("/login")
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

        Cookie cookie = new Cookie("tkn", response.getJwt());

        servletResponse.addCookie(cookie);

        //servletResponse.addHeader("Set-Cookie", "tkn=" + response.getJwt() + ";");
        // servletResponse.addHeader("Set-Cookie", "access-token=" + response.getJwt() + "; Secure; HttpOnly");

        return "process";
    }

    @PostMapping("/process")
    public String process(Model model,
                          @ModelAttribute("response") LoginResponse response,
                          HttpServletResponse servletResponse){

        return "redirect:/";
    }*/

}
