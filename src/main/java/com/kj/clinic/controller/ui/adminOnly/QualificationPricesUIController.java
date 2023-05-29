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
import com.kj.clinic.model.Qualification;
import com.kj.clinic.model.QualificationPrices;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOCreate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOUpdate;
import com.kj.clinic.services.service.personnel.PersonnelServiceImpl;
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

@RequestMapping("/database/qualificationPrices")
@Controller
public class QualificationPricesUIController {

    @Autowired
    QualificationPricesServiceImpl qualificationPricesService;

    @Autowired
    QualificationServiceImpl qualificationService;

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        qualificationPricesService.deleteById(id);

        return "redirect:/database/qualificationPrices/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public String create(Model model){

        QualificationPricesDTOCreate qualificationPricesDTOCreate = new QualificationPricesDTOCreate();
        qualificationPricesDTOCreate.setName("");
        qualificationPricesDTOCreate.setPrice("");
        qualificationPricesDTOCreate.setQualification("");

        model.addAttribute("qualificationPrices", qualificationPricesDTOCreate);

        List<String> qualifications = qualificationService.findAll()
                .stream()
                .map(Qualification::getName)
                .collect(Collectors.toList());

        model.addAttribute("qualification", qualifications);

        return "x-database/qualificationPrices/qualificationPrices-create";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("qualificationPrices") QualificationPricesDTOCreate qualificationPricesDTOCreate){

        qualificationPricesService.createUI(qualificationPricesDTOCreate);

        return "redirect:/database/qualificationPrices/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id){

        QualificationPricesDTOUpdate qualificationPricesDTOUpdate = new QualificationPricesDTOUpdate();
        qualificationPricesDTOUpdate.setId(id);
        qualificationPricesDTOUpdate.setName(qualificationPricesService.findById(id).getName());
        qualificationPricesDTOUpdate.setPrice(qualificationPricesService.findById(id).getPrice().toString());
        qualificationPricesDTOUpdate.setQualification(qualificationPricesService.findById(id).getQualification().getName());

        model.addAttribute("qualificationPrices", qualificationPricesDTOUpdate);

        List<String> qualifications = qualificationService.findAll()
                .stream()
                .map(Qualification::getName)
                .collect(Collectors.toList());

        model.addAttribute("qualification", qualifications);

        return "x-database/qualificationPrices/qualificationPrices-update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @ModelAttribute("qualificationPrices") QualificationPricesDTOUpdate qualificationPricesDTOUpdate,
                         @PathVariable String id){


        qualificationPricesService.updateUI(qualificationPricesDTOUpdate);

        return "redirect:/database/qualificationPrices/find/all";
    }

}