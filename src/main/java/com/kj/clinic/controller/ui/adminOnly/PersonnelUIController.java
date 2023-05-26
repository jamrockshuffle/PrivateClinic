/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.05.23, 14:44
 *  * @Version: PersonnelController: 1.0
 *
 */

package com.kj.clinic.controller.ui.adminOnly;

import com.kj.clinic.model.Personnel;
import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.services.service.personnel.PersonnelServiceImpl;
import com.kj.clinic.services.service.personnelCategory.PersonnelCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/database/personnel")
@Controller
public class PersonnelUIController {

    @Autowired
    PersonnelServiceImpl personnelService;

    @RequestMapping("/find/all")
    public String findAll(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
            List<Personnel> personnel = personnelService.findAll();
            model.addAttribute("personnel", personnel);
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());

            return "x-database/personnel/personnel-page";
        } else {
            return "redirect:/database/dbentry";
        }
    }
}