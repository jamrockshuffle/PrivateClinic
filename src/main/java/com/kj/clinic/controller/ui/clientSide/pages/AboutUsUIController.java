
/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 02.05.23, 12:36
 *  * @Version: AboutUsUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.clientSide.pages;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUsUIController {

    @RequestMapping("/about-us")
    public String display(Model model,
                                  SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());
            return "aboutUs/about-us-logged";
        } else {
            return "aboutUs/about-us";
        }
    }
}
