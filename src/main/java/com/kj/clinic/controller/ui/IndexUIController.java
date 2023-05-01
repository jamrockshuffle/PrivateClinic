/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.04.23, 12:48
 *  * @Version: IndexUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui;

import com.kj.clinic.security.AuthService;
import com.kj.clinic.security.controller.rest.AuthController;
import com.kj.clinic.security.controller.ui.AuthUIController;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexUIController {

    /*private String getToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        return StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")
                ? authHeader.substring(7)
                : null;
    }*/


    @RequestMapping("/")
    public String displayMainPage(SecurityContextHolderAwareRequestWrapper requestWrapper,
                                  HttpServletRequest servlet,
                                  HttpServletResponse response
                                  /*@ModelAttribute("loginResponse")LoginResponse loginResponse*/){

        if (requestWrapper.isUserInRole("ROLE_USER")) {
            return "mainPage/index";
        } else {
            return "mainPage/index-logged";
        }
    }
}
