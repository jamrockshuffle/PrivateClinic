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
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.service.examinations.ExaminationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

    @Autowired
    ExaminationsServiceImpl service;

    public Patients getByUsername(String username) {
        return patientsRepo.findAll().stream()
                .filter(item -> item.getUsername()
                        .equals(username))
                .findFirst()
                .orElse(null);
    }

    public QualificationPrices getByQPrice(String name) {
        return qualificationPricesRepo.findAll().stream()
                .filter(item -> item.getName()
                        .equals(name))
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

            List<Qualification> qualifications = new ArrayList<>(qualificationRepo.findAll());
            model.addAttribute("qualifications", qualifications);

            List<Personnel> doctors = new ArrayList<>(personnelRepo.findAll());
            model.addAttribute("doctors", doctors);

            List<QualificationPrices> services = new ArrayList<>(qualificationPricesRepo.findAll());
            model.addAttribute("services", services);

            return "examinationForm/examination-form";
        } else {
            return "redirect:/logIn";
        }
    }

    @PostMapping("/online-zapys")
    public String createExamination(Model model,
                                @ModelAttribute("examination") ExaminationForm examination,
                                    SecurityContextHolderAwareRequestWrapper requestWrapper){

        ExaminationsDTOCreate examinationsDTO = new ExaminationsDTOCreate();
        examinationsDTO.setPatient(this.getByUsername(requestWrapper.getUserPrincipal().getName()).getId());
        examinationsDTO.setDoctor(examination.getDoctor());
        examinationsDTO.setQualification(examination.getQualificationPrice());
        examinationsDTO.setExaminationTime(examination.getExaminationTime());

        service.createUI(examinationsDTO);

        return "examinationForm/examination-form-continue";
    }

    @GetMapping("/online-zapys/{serviceName}")
    public String createExaminationByPrice(Model model,
                                    SecurityContextHolderAwareRequestWrapper requestWrapper,
                                           @PathVariable String serviceName){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            ExaminationForm examinationCustom = new ExaminationForm();

            String fullName = this.getByUsername(requestWrapper.getUserPrincipal().getName()).getName();
            String[] names = fullName.split(" ");

            examinationCustom.setFirstName(names[0]);
            examinationCustom.setLastName(names[1]);
            examinationCustom.setQualification(this.getByQPrice(serviceName).getQualification().getName());
            examinationCustom.setDoctor("");
            examinationCustom.setQualificationPrice(this.getByQPrice(serviceName).getName());
            examinationCustom.setExaminationTime("");

            model.addAttribute("examinationCustom", examinationCustom);

            List<Personnel> doctors = new ArrayList<>(personnelRepo.findAll());
            model.addAttribute("doctors", doctors);

            return "examinationForm/examination-form-custom";
        } else {
            return "redirect:/logIn";
        }
    }

    @PostMapping("/online-zapys/{serviceName}")
    public String createExaminationByPrice(Model model,
                                    @ModelAttribute("examinationCustom") ExaminationForm examinationCustom,
                                    SecurityContextHolderAwareRequestWrapper requestWrapper){

        ExaminationsDTOCreate examinationsDTO = new ExaminationsDTOCreate();
        examinationsDTO.setPatient(this.getByUsername(requestWrapper.getUserPrincipal().getName()).getId());
        examinationsDTO.setDoctor(examinationCustom.getDoctor());
        examinationsDTO.setQualification(examinationCustom.getQualificationPrice());
        examinationsDTO.setExaminationTime(examinationCustom.getExaminationTime());

        service.createUI(examinationsDTO);

        return "examinationForm/examination-form-continue";
    }
}
