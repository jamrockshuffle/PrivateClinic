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
import com.kj.clinic.model.Qualification;
import com.kj.clinic.services.dto.personnel.PersonnelDTOCreate;
import com.kj.clinic.services.dto.personnel.PersonnelDTOUpdate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOCreate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOCreate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOUpdate;
import com.kj.clinic.services.service.personnel.PersonnelServiceImpl;
import com.kj.clinic.services.service.personnelCategory.PersonnelCategoryServiceImpl;
import com.kj.clinic.services.service.qualification.QualificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/database/personnel")
@Controller
public class PersonnelUIController {

    @Autowired
    PersonnelServiceImpl personnelService;

    @Autowired
    QualificationServiceImpl qualificationService;

    @Autowired
    PersonnelCategoryServiceImpl personnelCategoryService;

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        personnelService.deleteById(id);

        return "redirect:/database/personnel/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public String create(Model model){

        PersonnelDTOCreate personnelDTOCreate = new PersonnelDTOCreate();
        personnelDTOCreate.setName("");
        personnelDTOCreate.setPersonnelCategory("");
        personnelDTOCreate.setQualification("");

        model.addAttribute("personnel", personnelDTOCreate);

        List<String> qualifications = qualificationService.findAll()
                .stream()
                .map(Qualification::getName)
                .collect(Collectors.toList());

        model.addAttribute("qualification", qualifications);

        List<String> categories = personnelCategoryService.findAll()
                .stream()
                .map(PersonnelCategory::getName)
                .collect(Collectors.toList());

        model.addAttribute("personnelCategory", categories);

        return "x-database/personnel/personnel-create";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("personnelCategory") PersonnelDTOCreate personnelDTOCreate){

        personnelService.createUI(personnelDTOCreate);

        return "redirect:/database/personnel/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id){

        PersonnelDTOUpdate personnelDTOUpdate = new PersonnelDTOUpdate();
        personnelDTOUpdate.setId(id);
        personnelDTOUpdate.setName(personnelService.findById(id).getName());
        personnelDTOUpdate.setPersonnelCategory(personnelService.findById(id).getPersonnelCategory().getName());
        personnelDTOUpdate.setQualification(personnelService.findById(id).getQualification().getName());

        model.addAttribute("personnel", personnelDTOUpdate);

        List<String> qualifications = qualificationService.findAll()
                .stream()
                .map(Qualification::getName)
                .collect(Collectors.toList());

        model.addAttribute("qualification", qualifications);

        List<String> categories = personnelCategoryService.findAll()
                .stream()
                .map(PersonnelCategory::getName)
                .collect(Collectors.toList());

        model.addAttribute("personnelCategory", categories);

        return "x-database/personnel/personnel-update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @ModelAttribute("personnel") PersonnelDTOUpdate personnelDTOUpdate,
                         @PathVariable String id){

        personnelService.updateUI(personnelDTOUpdate);

        return "redirect:/database/personnel/find/all";
    }
}