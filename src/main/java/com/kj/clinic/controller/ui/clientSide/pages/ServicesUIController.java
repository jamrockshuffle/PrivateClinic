/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 02.05.23, 12:59
 *  * @Version: ServicesUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.clientSide.pages;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServicesUIController {

    @RequestMapping("/services")
    public String display(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());
            return "services/services-logged";
        } else {
            return "services/services";
        }
    }

    @RequestMapping("/services/{name}")
    public String display(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper,
                          @PathVariable String name){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());
            return "services/detailed/"+name+"/services-"+name+"-logged";
        } else {
            return "services/detailed/"+name+"/services-"+name;
        }
    }
}
