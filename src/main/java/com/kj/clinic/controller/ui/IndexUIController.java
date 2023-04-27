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
import com.kj.clinic.security.controller.jwtService.JwtHandler;
import com.kj.clinic.security.controller.rest.AuthController;
import com.kj.clinic.security.controller.ui.AuthUIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexUIController {

    @Autowired
    JwtHandler jwtHandler;

    @RequestMapping("/")
    public String displayMainPage(SecurityContextHolderAwareRequestWrapper requestWrapper,
                                  HttpServletRequest servlet,
                                  HttpServletResponse response){

        System.out.println(jwtHandler.getJwt());

        if (requestWrapper.isUserInRole("ROLE_USER")) {
            return "mainPage/index";
        } else {
            return "mainPage/index-logged";
        }
    }
}
