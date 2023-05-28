/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.05.23, 14:45
 *  * @Version: QualificationPricesUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.adminOnly;

import com.kj.clinic.model.Personnel;
import com.kj.clinic.model.QualificationPrices;
import com.kj.clinic.services.service.personnel.PersonnelServiceImpl;
import com.kj.clinic.services.service.qualificationPrices.QualificationPricesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/database/qualificationPrices")
@Controller
public class QualificationPricesUIController {

    @Autowired
    QualificationPricesServiceImpl qualificationPricesService;

    @RequestMapping("/find/all")
    public String findAll(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
            List<QualificationPrices> qualificationPrices = qualificationPricesService.findAll();
            model.addAttribute("qualificationPrices", qualificationPrices);
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());

            return "x-database/qualificationPrices/qualificationPrices-page";
        } else {
            return "redirect:/database/dbentry";
        }
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        qualificationPricesService.deleteById(id);

        return "redirect:/database/qualificationPrices/find/all";
    }
}