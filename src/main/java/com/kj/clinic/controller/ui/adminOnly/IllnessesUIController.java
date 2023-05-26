/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.05.23, 14:41
 *  * @Version: IllnessesUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.adminOnly;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.model.Illnesses;
import com.kj.clinic.services.service.examinations.ExaminationsServiceImpl;
import com.kj.clinic.services.service.illnesses.IllnessesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/database/illnesses")
@Controller
public class IllnessesUIController {

    @Autowired
    IllnessesServiceImpl illnessesService;

    @RequestMapping("/find/all")
    public String findAll(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
            List<Illnesses> illnesses = illnessesService.findAll();
            model.addAttribute("illnesses", illnesses);
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());

            return "x-database/illnesses/illnesses-page";
        } else {
            return "redirect:/database/dbentry";
        }
    }
}