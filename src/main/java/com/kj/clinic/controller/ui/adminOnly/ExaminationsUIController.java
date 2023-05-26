/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.05.23, 09:49
 *  * @Version: ExaminationsUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.adminOnly;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.repository.ExaminationsRepo;
import com.kj.clinic.services.service.examinations.ExaminationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/database/examinations")
@Controller
public class ExaminationsUIController {

    @Autowired
    ExaminationsServiceImpl examinationsService;

    @RequestMapping("/find/all")
    public String findAll(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
            List<Examinations> examinations = examinationsService.findAll();
            model.addAttribute("examinations", examinations);
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());

            return "x-database/examinations/examinations-page";
        } else {
            return "redirect:/database/dbentry";
        }
    }
}
