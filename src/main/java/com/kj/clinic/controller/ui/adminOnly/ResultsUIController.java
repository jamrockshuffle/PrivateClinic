/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.05.23, 15:35
 *  * @Version: ResultsUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.adminOnly;

import com.kj.clinic.model.Qualification;
import com.kj.clinic.model.Results;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;
import com.kj.clinic.services.dto.results.ResultsDTOCreate;
import com.kj.clinic.services.dto.results.ResultsDTOUpdate;
import com.kj.clinic.services.service.qualification.QualificationServiceImpl;
import com.kj.clinic.services.service.results.ResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/database/results")
@Controller
public class ResultsUIController {

    @Autowired
    ResultsServiceImpl resultsService;

    @RequestMapping("/find/all")
    public String findAll(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
            List<Results> results = resultsService.findAll();
            model.addAttribute("results", results);
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());

            return "x-database/results/results-page";
        } else {
            return "redirect:/database/dbentry";
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        resultsService.deleteById(id);

        return "redirect:/database/results/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public String create(Model model){

        ResultsDTOCreate resultsDTOCreate = new ResultsDTOCreate();
        resultsDTOCreate.setExaminationId("");
        resultsDTOCreate.setPrescription("");
        model.addAttribute("results", resultsDTOCreate);

        return "x-database/results/results-create";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("results") ResultsDTOCreate resultsDTOCreate){

        resultsService.create(resultsDTOCreate);

        return "redirect:/database/results/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id){

        ResultsDTOUpdate resultsDTOUpdate = new ResultsDTOUpdate();

        resultsDTOUpdate.setId(id);
        resultsDTOUpdate.setExaminationDate(resultsService.findById(id).getExaminationDate().toString());
        resultsDTOUpdate.setQualification(resultsService.findById(id).getQualification().getName());
        resultsDTOUpdate.setPatient(resultsService.findById(id).getPatient().getName());
        resultsDTOUpdate.setExaminationId(resultsService.findById(id).getExaminationId());
        resultsDTOUpdate.setPrescription(resultsService.findById(id).getPrescription());

        model.addAttribute("results", resultsDTOUpdate);

        return "x-database/results/results-update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @ModelAttribute("results") ResultsDTOUpdate resultsDTOUpdate,
                         @PathVariable String id){

        resultsService.update(resultsDTOUpdate);

        return "redirect:/database/results/find/all";
    }
}