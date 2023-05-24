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
import com.kj.clinic.security.UserDetailsImpl;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.dto.SignUpRequest;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import com.kj.clinic.security.model.User;
import com.kj.clinic.security.repository.UserRepository;
import com.kj.clinic.services.dto.SignUpForm;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
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
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;


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

            //secure httponly samesite=strict
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
                        @RequestParam(required = false) String newUsername,
                        final RedirectAttributes redirectAttributes){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/";
        } else {
            LoginRequest request = new LoginRequest();
            request.setUsername("");
            request.setPassword("");

            model.addAttribute("request", request);

            if (newUsername != null) {
                redirectAttributes.addFlashAttribute("newUsername", newUsername);
                model.addAttribute("newUsername", newUsername);
            } else {
                redirectAttributes.addFlashAttribute("newUsername", "");
                model.addAttribute("newUsername", "");
            }

            if (authsuccess != null) {
                return "account/logIn/log-in-username-exists";
            } else {
                return "account/logIn/log-in";
            }
        }
    }

    @PostMapping("/logIn")
    public String logIn(Model model,
                          @ModelAttribute("request") LoginRequest request,
                        @ModelAttribute("newUsername") String newUsername,
                        HttpServletResponse servletResponse,
                        @RequestParam(required = false) String rememberMe){

        if (service.checkValidity(request)) {
                LoginResponse response = service.authenticateRequest(request);

                //secure httponly samesite=strict
                // servletResponse.addHeader("Set-Cookie", "access-token=" + response.getJwt() + "; Secure; HttpOnly");

                if (rememberMe != null) {
                    Cookie cookie = new Cookie("tkn", response.getJwt());
                    cookie.setMaxAge(604800);
                    servletResponse.addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("tkn", response.getJwt());
                    servletResponse.addCookie(cookie);
                }
                if (newUsername.equals("")) return "goBack/goBackByTwo"; else return "redirect:/cabinet";
            } else {
                return "redirect:/logIn?authsuccess=false";
            }

    }

    @GetMapping("/logOut")
    public String logOut(Model model,
                         HttpServletResponse response,
                         HttpServletRequest request){

        Cookie cookie = new Cookie("tkn", null);
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        //String referer = request.getHeader("Referer");
        //return "redirect:" + referer;

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
}
