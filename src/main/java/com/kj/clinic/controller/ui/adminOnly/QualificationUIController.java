/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.05.23, 14:44
 *  * @Version: QualificationController: 1.0
 *
 */

package com.kj.clinic.controller.ui.adminOnly;

import com.kj.clinic.model.Qualification;
import com.kj.clinic.model.QualificationPrices;
import com.kj.clinic.services.service.qualification.QualificationServiceImpl;
import com.kj.clinic.services.service.qualificationPrices.QualificationPricesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/database/qualification")
@Controller
public class QualificationUIController {

    @Autowired
    QualificationServiceImpl qualificationService;

    @RequestMapping("/find/all")
    public String findAll(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
            List<Qualification> qualification = qualificationService.findAll();
            model.addAttribute("qualifications", qualification);
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());

            return "x-database/qualification/qualification-page";
        } else {
            return "redirect:/database/dbentry";
        }
    }
}