/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.05.23, 14:44
 *  * @Version: PersonnelCategoryUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.adminOnly;

import com.kj.clinic.model.Patients;
import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
import com.kj.clinic.services.service.personnelCategory.PersonnelCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/database/personnelCategory")
@Controller
public class PersonnelCategoryUIController {

    @Autowired
    PersonnelCategoryServiceImpl personnelCategoryService;

    @RequestMapping("/find/all")
    public String findAll(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
            List<PersonnelCategory> personnelCategory = personnelCategoryService.findAll();
            model.addAttribute("personnelCategories", personnelCategory);
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());

            return "x-database/personnelCategory/personnelCategory-page";
        } else {
            return "redirect:/database/dbentry";
        }
    }
}