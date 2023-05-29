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
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;
import com.kj.clinic.services.service.examinations.ExaminationsServiceImpl;
import com.kj.clinic.services.service.illnesses.IllnessesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        illnessesService.deleteById(id);

        return "redirect:/database/illnesses/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public String create(Model model){

        IllnessesDTOCreate illnessesDTOCreate = new IllnessesDTOCreate();
        illnessesDTOCreate.setName("");
        model.addAttribute("illnesses", illnessesDTOCreate);

        return "x-database/illnesses/illnesses-create";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("illnesses") IllnessesDTOCreate illnessesDTOCreate){

        illnessesService.create(illnessesDTOCreate);

        return "redirect:/database/illnesses/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id){

        IllnessesDTOUpdate illnessesDTOUpdate = new IllnessesDTOUpdate();

        illnessesDTOUpdate.setId(id);
        illnessesDTOUpdate.setName(illnessesService.findById(id).getName());

        model.addAttribute("illnesses", illnessesDTOUpdate);

        return "x-database/illnesses/illnesses-update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @ModelAttribute("illnesses") IllnessesDTOUpdate illnessesDTOUpdate,
                         @PathVariable String id){

        illnessesService.update(illnessesDTOUpdate);

        return "redirect:/database/illnesses/find/all";
    }
}