/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 02.05.23, 12:59
 *  * @Version: PricesUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.clientSide.pages;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PricesUIController {

    @RequestMapping("/prices")
    public String display(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());
            return "prices/prices-logged";
        } else {
            return "prices/prices";
        }
    }
}
