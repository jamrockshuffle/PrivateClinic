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
import com.kj.clinic.repository.IllnessesRepo;
import com.kj.clinic.security.AuthService;
import com.kj.clinic.security.bruteForce.GetClientIP;
import com.kj.clinic.security.bruteForce.LoginAttemptService;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import com.kj.clinic.security.model.User;
import com.kj.clinic.security.repository.UserRepository;
import com.kj.clinic.services.dto.SignUpForm;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthUIController {

    @Autowired
    AuthService service;

    @Autowired
    IllnessesRepo illnessesRepo;

    @Autowired
    PatientsServiceImpl patientsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    LoginAttemptService loginAttemptService;


    @GetMapping("/signUp")
    public String createAccount(Model model,
                                SecurityContextHolderAwareRequestWrapper requestWrapper,
                                @RequestParam(required = false) String authsuccess){

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

            if (authsuccess != null) {
                return "account/signUp/sign-up-username-exists";
            } else {
                return "account/signUp/sign-up";
            }
        }
    }


    @PostMapping("/signUp")
    public String createAccount(Model model,
                                @ModelAttribute("request") SignUpForm request,
                                HttpServletResponse servletResponse){

        List<String> usernames = userRepository.findAll()
                .stream()
                .map(User::getUsername)
                .collect(Collectors.toList());

        if(usernames.contains(request.getUsername())) {
            return "redirect:/signUp?authsuccess=false";
        } else {
            PatientsDTOCreate patients = new PatientsDTOCreate();
            patients.setName(request.getFirstName() + " " + request.getLastName());
            patients.setBirthday(request.getBirthday());
            patients.setPhone(request.getPhone());
            patients.setEmail(request.getEmail());
            patients.setIllnesses(request.getIllnesses());
            patients.setUsername(request.getUsername());

            patientsService.createUI(patients);

            SignUpRequestNoLogin requestNoLogin = new SignUpRequestNoLogin();
            requestNoLogin.setUsername(request.getUsername());
            requestNoLogin.setPassword(request.getPassword());
            ResponseEntity.ok(service.signUpUserNoLogin(requestNoLogin));

            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setUsername(request.getUsername());
            loginRequest.setPassword(request.getPassword());

            LoginResponse response = service.authenticateRequest(loginRequest);

            // secure httponly samesite=strict
            // servletResponse.addHeader("Set-Cookie", "access-token=" + response.getJwt() + "; Secure; HttpOnly");

            Cookie cookie = new Cookie("tkn", response.getJwt());
            servletResponse.addCookie(cookie);

            return "account/signUp/sign-up-continue";
        }
    }

    @GetMapping("/logIn")
    public String logIn(Model model,
                        SecurityContextHolderAwareRequestWrapper requestWrapper,
                        HttpServletRequest servletRequest,
                        @RequestParam(required = false) String authsuccess,
                        @RequestParam(required = false) String paramUsername,
                        final RedirectAttributes redirectAttributes){

        if (loginAttemptService.checkIfIPBlocked(GetClientIP.getClientIP(servletRequest))) {
            return "account/logIn/log-in-ip-blocked";
        } else {
            if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
                return "redirect:/";
            } else {
                LoginRequest request = new LoginRequest();
                request.setUsername("");
                request.setPassword("");

                model.addAttribute("request", request);

                if (paramUsername != null) {
                    redirectAttributes.addFlashAttribute("paramUsername", paramUsername);
                    model.addAttribute("paramUsername", paramUsername);
                } else {
                    redirectAttributes.addFlashAttribute("paramUsername", "");
                    model.addAttribute("paramUsername", "");
                }

                if (authsuccess != null) {
                    return "account/logIn/log-in-username-exists";
                } else {
                    return "account/logIn/log-in";
                }
            }
        }
    }

    @PostMapping("/logIn")
    public String logIn(Model model,
                          @ModelAttribute("request") LoginRequest request,
                        @ModelAttribute("paramUsername") String paramUsername,
                        HttpServletResponse servletResponse,
                        @RequestParam(required = false) String rememberMe){

        if (request.getUsername().equals("admin")) {
            return "redirect:/logIn?authsuccess=false";
        } else {
            if (service.checkValidity(request)) {
                LoginResponse response = service.authenticateRequest(request);

                // secure httponly samesite=strict
                // servletResponse.addHeader("Set-Cookie", "access-token=" + response.getJwt() + "; Secure; HttpOnly");

                if (rememberMe != null) {
                    Cookie cookie = new Cookie("tkn", response.getJwt());
                    cookie.setMaxAge(604800);
                    servletResponse.addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("tkn", response.getJwt());
                    servletResponse.addCookie(cookie);
                }

                if (paramUsername.equals("")) {
                    return "goBack/goBackByTwo";
                } else {
                    return "redirect:/cabinet";
                }
            } else {
                return "redirect:/logIn?authsuccess=false";
            }
        }
    }

    @GetMapping("/logOut")
    public String logOut(Model model,
                         HttpServletResponse response,
                         HttpServletRequest request){

        Cookie cookie = new Cookie("tkn", null);
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        // String referer = request.getHeader("Referer");
        // return "redirect:" + referer;

        return "goBack/goBackByOne";
    }

    @GetMapping("/login")
    public String login(){

        return "redirect:/logIn";
    }

    @GetMapping("/logout")
    public String logout(){

        return "redirect:/logOut";
    }

    @GetMapping("/database/dbentry")
    public String dbEntry(Model model,
                        SecurityContextHolderAwareRequestWrapper requestWrapper,
                        HttpServletRequest servletRequest,
                        @RequestParam(required = false) String authsuccess){

        if (loginAttemptService.checkIfIPBlocked(GetClientIP.getClientIP(servletRequest))) {
            return "x-database/logIn/db-log-in-ip-blocked";
        } else {
            if (requestWrapper.isUserInRole("ROLE_USER")) {
                return "redirect:/";
            } else if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
                return "redirect:/database/main";
            } else {
                LoginRequest request = new LoginRequest();
                request.setUsername("");
                request.setPassword("");

                model.addAttribute("request", request);

                if (authsuccess != null) {
                    return "x-database/logIn/db-log-in-auth-fail";
                } else {
                    return "x-database/logIn/db-log-in";
                }
            }
        }
    }

    @PostMapping("/database/dbentry")
    public String dbEntry(Model model,
                        @ModelAttribute("request") LoginRequest request,
                        HttpServletResponse servletResponse,
                        @RequestParam(required = false) String rememberMe){

        if (service.checkValidity(request)) {
            LoginResponse response = service.authenticateRequest(request);

            // secure httponly samesite=strict
            // servletResponse.addHeader("Set-Cookie", "access-token=" + response.getJwt() + "; Secure; HttpOnly");
            Cookie cookie = new Cookie("tkn", response.getJwt());
            cookie.setMaxAge(3600);
            servletResponse.addCookie(cookie);

            return "redirect:/database/main";

        } else {
            return "redirect:/database/dbentry?authsuccess=false";
        }

    }

    @GetMapping("/database/logout")
    public String dbLogout(Model model,
                         HttpServletResponse response,
                         HttpServletRequest request){

        Cookie cookie = new Cookie("tkn", null);
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        // String referer = request.getHeader("Referer");
        // return "redirect:" + referer;

        return "goBack/goBackByOne";
    }
}
