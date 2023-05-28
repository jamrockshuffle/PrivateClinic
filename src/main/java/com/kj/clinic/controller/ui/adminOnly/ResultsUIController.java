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
import com.kj.clinic.services.service.qualification.QualificationServiceImpl;
import com.kj.clinic.services.service.results.ResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        resultsService.deleteById(id);

        return "redirect:/database/results/find/all";
    }
}