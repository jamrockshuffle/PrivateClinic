/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 02.05.23, 12:53
 *  * @Version: DoctorsUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.clientSide.pages;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorsUIController {

    @RequestMapping("/doctors")
    public String display(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());
            return "doctors/doctors-logged";
        } else {
            return "doctors/doctors";
        }
    }
}
