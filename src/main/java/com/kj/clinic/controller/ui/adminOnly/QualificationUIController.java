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
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;
import com.kj.clinic.services.service.qualification.QualificationServiceImpl;
import com.kj.clinic.services.service.qualificationPrices.QualificationPricesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        List<QualificationPrices> qualificationPricesList = getPricesByQualification(qualificationService
                .findById(id).getName());

        qualificationPricesList.forEach(price -> qualificationPricesService
                .deleteById(price.getId()));

        qualificationService.deleteById(id);

        return "redirect:/database/qualification/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public String create(Model model){

        QualificationDTOCreate qualificationDTOCreate = new QualificationDTOCreate();
        qualificationDTOCreate.setName("");
        model.addAttribute("qualification", qualificationDTOCreate);

        return "x-database/qualification/qualification-create";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("qualification") QualificationDTOCreate qualificationDTOCreate){

        qualificationService.create(qualificationDTOCreate);

        return "redirect:/database/qualification/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id){

        QualificationDTOUpdate qualificationDTOUpdate = new QualificationDTOUpdate();

        qualificationDTOUpdate.setId(id);
        qualificationDTOUpdate.setName(qualificationService.findById(id).getName());

        model.addAttribute("qualification", qualificationDTOUpdate);

        return "x-database/qualification/qualification-update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @ModelAttribute("qualification") QualificationDTOUpdate qualificationDTOUpdate,
                         @PathVariable String id){

        qualificationService.update(qualificationDTOUpdate);

        return "redirect:/database/qualification/find/all";
    }
}