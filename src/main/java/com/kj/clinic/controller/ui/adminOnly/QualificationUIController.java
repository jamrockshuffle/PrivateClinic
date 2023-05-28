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
import com.kj.clinic.model.Results;
import com.kj.clinic.services.service.qualification.QualificationServiceImpl;
import com.kj.clinic.services.service.qualificationPrices.QualificationPricesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/database/qualification")
@Controller
public class QualificationUIController {

    @Autowired
    QualificationServiceImpl qualificationService;

    @Autowired
    QualificationPricesServiceImpl qualificationPricesService;

    public List<QualificationPrices> getPricesByQualification(String qualification) {
        return qualificationPricesService.findAll().stream()
                .filter(item -> item.getQualification().getName()
                        .equals(qualification)).collect(Collectors.toList());
    }

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

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        List<QualificationPrices> qualificationPricesList = getPricesByQualification(qualificationService
                .findById(id).getName());

        qualificationPricesList.forEach(price -> qualificationPricesService
                .deleteById(price.getId()));

        qualificationService.deleteById(id);

        return "redirect:/database/qualification/find/all";
    }
}