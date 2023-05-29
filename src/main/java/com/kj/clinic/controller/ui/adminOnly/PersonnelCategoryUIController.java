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
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOCreate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOUpdate;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
import com.kj.clinic.services.service.personnelCategory.PersonnelCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        personnelCategoryService.deleteById(id);

        return "redirect:/database/personnelCategory/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public String create(Model model){

        PersonnelCategoryDTOCreate personnelCategoryDTOCreate = new PersonnelCategoryDTOCreate();
        personnelCategoryDTOCreate.setName("");
        model.addAttribute("personnelCategory", personnelCategoryDTOCreate);

        return "x-database/personnelCategory/personnelCategory-create";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("personnelCategory") PersonnelCategoryDTOCreate personnelCategoryDTOCreate){

        personnelCategoryService.create(personnelCategoryDTOCreate);

        return "redirect:/database/personnelCategory/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id){

        PersonnelCategoryDTOUpdate personnelCategoryDTOUpdate = new PersonnelCategoryDTOUpdate();

        personnelCategoryDTOUpdate.setId(id);
        personnelCategoryDTOUpdate.setName(personnelCategoryService.findById(id).getName());

        model.addAttribute("personnelCategory", personnelCategoryDTOUpdate);

        return "x-database/personnelCategory/personnelCategory-update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @ModelAttribute("personnelCategory") PersonnelCategoryDTOUpdate personnelCategoryDTOUpdate,
                         @PathVariable String id){

        personnelCategoryService.update(personnelCategoryDTOUpdate);

        return "redirect:/database/personnelCategory/find/all";
    }
}