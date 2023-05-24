/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 23.05.23, 17:14
 *  * @Version: SettingsUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.clientSide.pages;

import com.kj.clinic.security.AuthService;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.model.User;
import com.kj.clinic.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SettingsUIController {

    @Autowired
    AuthService service;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/settings")
    public String display(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());
            return "settings/settings";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/changeusername")
    public String changeUsername(Model model,
                        SecurityContextHolderAwareRequestWrapper requestWrapper,
                        HttpServletRequest servletRequest,
                        @RequestParam(required = false) String authsuccess,
                        @RequestParam(required = false) String exists){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {

            LoginRequest request = new LoginRequest();
            request.setUsername(requestWrapper.getUserPrincipal().getName());
            request.setPassword("");

            model.addAttribute("request", request);

            if (exists != null) {
                return "settings/changeUsername/change-username-exists";
            } else if (authsuccess != null) {
                return "settings/changeUsername/change-username-auth-fail";
            } else {
                return "settings/changeUsername/change-username";
            }

        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/changeusername")
    public String changeUsername(Model model,
                        @ModelAttribute("request") LoginRequest request,
                        HttpServletResponse servletResponse,
                        @RequestParam String newUsername){

        if (service.checkValidity(request)) {
            List<String> usernames = userRepository.findAll()
                    .stream()
                    .map(User::getUsername)
                    .collect(Collectors.toList());

            if(usernames.contains(newUsername)) {
                return "redirect:/changeusername?exists=true";
            } else {
                service.changeUsername(request.getUsername(), newUsername);

                Cookie cookie = new Cookie("tkn", null);
                cookie.setMaxAge(0);
                servletResponse.addCookie(cookie);

                return "redirect:/logIn?paramUsername="+newUsername;
            }
        } else {
            return "redirect:/changeusername?authsuccess=false";
        }
    }

    @GetMapping("/changepassword")
    public String changePassword(Model model,
                                 SecurityContextHolderAwareRequestWrapper requestWrapper,
                                 HttpServletRequest servletRequest,
                                 @RequestParam(required = false) String authsuccess){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {

            LoginRequest request = new LoginRequest();
            request.setUsername(requestWrapper.getUserPrincipal().getName());
            request.setPassword("");

            model.addAttribute("request", request);

            if (authsuccess != null) {
                return "settings/changePassword/change-password-auth-fail";
            } else {
                return "settings/changePassword/change-password";
            }

        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/changepassword")
    public String changePassword(Model model,
                                 @ModelAttribute("request") LoginRequest request,
                                 HttpServletResponse servletResponse,
                                 @RequestParam String newPassword){
        if (service.checkValidity(request)) {
                service.changePassword(request.getUsername(), newPassword);

                Cookie cookie = new Cookie("tkn", null);
                cookie.setMaxAge(0);
                servletResponse.addCookie(cookie);

            return "redirect:/logIn?paramUsername="+request.getUsername();
        } else {
            return "redirect:/changepassword?authsuccess=false";
        }
    }
}
