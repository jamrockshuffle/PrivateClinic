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

import com.kj.clinic.model.Illnesses;
import com.kj.clinic.model.Patients;
import com.kj.clinic.repository.IllnessesRepo;
import com.kj.clinic.security.AuthService;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.dto.SignUpRequest;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import com.kj.clinic.services.dto.SignUpForm;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AuthUIController {

    private final AuthService service;
    private final IllnessesRepo illnessesRepo;
    private final PatientsServiceImpl patientsService;

    @GetMapping("/signUp")
    public String createAccount(Model model,
                                SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/";
        } else {

            SignUpForm request = new SignUpForm();
            request.setFirstName("");
            request.setLastName("");
            request.setBirthday("");
            request.setPhone("");
            request.setEmail("");
            request.setIllnesses("");
            request.setUsername("");
            request.setPassword("");

            model.addAttribute("request", request);

            List<String> illnesses = illnessesRepo.findAll()
                    .stream()
                    .map(Illnesses::getName)
                    .collect(Collectors.toList());

            model.addAttribute("illnesses", illnesses);

            return "account/signUp/sign-up";
        }
    }

    @PostMapping("/signUp")
    public String createAccount(Model model,
                                @ModelAttribute("request") SignUpForm request,
                                HttpServletResponse servletResponse){

        PatientsDTOCreate patients = new PatientsDTOCreate();
        patients.setName(request.getFirstName() + " " + request.getLastName());
        patients.setBirthday(request.getBirthday());
        patients.setPhone(request.getPhone());
        patients.setEmail(request.getEmail());
        patients.setIllnesses(request.getIllnesses());
        patients.setUsername(request.getUsername());

        System.out.println(request.getUsername());

        patientsService.createUI(patients);

        SignUpRequestNoLogin requestNoLogin = new SignUpRequestNoLogin();
        requestNoLogin.setUsername(request.getUsername());
        requestNoLogin.setPassword(request.getPassword());
        ResponseEntity.ok(service.signUpUserNoLogin(requestNoLogin));

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

            return "account/logIn/log-in";
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
