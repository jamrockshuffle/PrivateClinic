/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 09.05.23, 22:31
 *  * @Version: ExaminationFormUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.clientSide.pages;

import com.kj.clinic.model.*;
import com.kj.clinic.repository.PatientsRepo;
import com.kj.clinic.repository.PersonnelRepo;
import com.kj.clinic.repository.QualificationPricesRepo;
import com.kj.clinic.repository.QualificationRepo;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import com.kj.clinic.services.dto.ExaminationForm;
import com.kj.clinic.services.dto.SignUpForm;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ExaminationFormUIController {

    @Autowired
    PatientsRepo patientsRepo;

    @Autowired
    QualificationRepo qualificationRepo;

    @Autowired
    PersonnelRepo personnelRepo;

    @Autowired
    QualificationPricesRepo qualificationPricesRepo;

    public Patients getByUsername(String username) {
        return patientsRepo.findAll().stream()
                .filter(item -> item.getUsername()
                        .equals(username))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/online-zapys")
    public String createExamination(Model model,
                                SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            ExaminationForm examination = new ExaminationForm();

            String fullName = this.getByUsername(requestWrapper.getUserPrincipal().getName()).getName();
            String[] names = fullName.split(" ");

            examination.setFirstName(names[0]);
            examination.setLastName(names[1]);
            examination.setQualification("");
            examination.setDoctor("");
            examination.setQualificationPrice("");
            examination.setExaminationTime("");

            model.addAttribute("examination", examination);

            List<String> qualifications = qualificationRepo.findAll()
                    .stream()
                    .map(Qualification::getName)
                    .collect(Collectors.toList());

            model.addAttribute("qualifications", qualifications);

            List<String> doctors = personnelRepo.findAll()
                    .stream()
                    .map(Personnel::getName)
                    .collect(Collectors.toList());

            model.addAttribute("doctors", doctors);

            List<String> services = qualificationPricesRepo.findAll()
                    .stream()
                    .map(QualificationPrices::getName)
                    .collect(Collectors.toList());

            model.addAttribute("services", services);

            return "examinationForm/examination-form";
        } else {
            return "redirect:/logIn";
        }
    }

    @PostMapping("/online-zapys")
    public String createExamination(Model model,
                                @ModelAttribute("request") SignUpForm request,
                                HttpServletResponse servletResponse){


        return "examinationForm/examination-form-continue";
    }
}
