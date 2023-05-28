/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 26.05.23, 14:43
 *  * @Version: PatientsUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.adminOnly;

import com.kj.clinic.model.Illnesses;
import com.kj.clinic.model.Patients;
import com.kj.clinic.model.Results;
import com.kj.clinic.security.model.User;
import com.kj.clinic.security.repository.UserRepository;
import com.kj.clinic.services.service.illnesses.IllnessesServiceImpl;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/database/patients")
@Controller
public class PatientsUIController {

    @Autowired
    PatientsServiceImpl patientsService;

    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findAll().stream()
                .filter(item -> item.getUsername()
                        .equals(username))
                .findFirst()
                .orElse(null);
    }

    @RequestMapping("/find/all")
    public String findAll(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_ADMIN")) {
            List<Patients> patients = patientsService.findAll();
            model.addAttribute("patients", patients);
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());

            return "x-database/patients/patients-page";
        } else {
            return "redirect:/database/dbentry";
        }
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        User user = getUserByUsername(patientsService.findById(id).getUsername());
        patientsService.deleteById(id);
        userRepository.deleteById(user.getId());

        return "redirect:/database/patients/find/all";
    }
}