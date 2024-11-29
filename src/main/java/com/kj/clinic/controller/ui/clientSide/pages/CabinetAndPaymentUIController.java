/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 14.05.23, 20:34
 *  * @Version: CabinetUIController: 1.0
 *
 */

package com.kj.clinic.controller.ui.clientSide.pages;

import com.kj.clinic.medicalImageClassifier.service.ClassifierRepo;
import com.kj.clinic.medicalImageClassifier.service.ClassifierTable;
import com.kj.clinic.model.Examinations;
import com.kj.clinic.model.Patients;
import com.kj.clinic.model.Results;
import com.kj.clinic.repository.ExaminationsRepo;
import com.kj.clinic.repository.PatientsRepo;
import com.kj.clinic.repository.ResultsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CabinetAndPaymentUIController {

    @Autowired
    ExaminationsRepo examinationsRepo;

    @Autowired
    PatientsRepo patientsRepo;

    @Autowired
    ResultsRepo resultsRepo;

    @Autowired
    ClassifierRepo classifierRepo;

    public List<Results> getResultsByUsername(String username) {
        return resultsRepo.findAll().stream()
                .filter(item -> item.getPatient().getUsername()
                        .equals(username)).collect(Collectors.toList());
    }

    public List<Examinations> getByExaminationsUsername(String username) {
        return examinationsRepo.findAll().stream()
                .filter(item -> item.getPatient().getUsername()
                        .equals(username)).collect(Collectors.toList());
    }

    public Examinations getByExamId(String examId) {
        return examinationsRepo.findAll().stream()
                .filter(item -> item.getExaminationId()
                        .equals(examId))
                .findFirst()
                .orElse(null);
    }

    public Patients getPatientByUsername(String username) {
        return patientsRepo.findAll().stream()
                .filter(item -> item.getUsername()
                        .equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<ClassifierTable> getDiagnosesByUsername(String username) {
        return classifierRepo.findAll().stream()
                .filter(item -> item.getUsername()
                        .equals(username)).collect(Collectors.toList());
    }

    @RequestMapping("/cabinet")
    public String display(Model model,
                          SecurityContextHolderAwareRequestWrapper requestWrapper){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {
            model.addAttribute("username", requestWrapper.getUserPrincipal().getName());

            List<Examinations> examinations = this.getByExaminationsUsername(requestWrapper.getUserPrincipal().getName());
            model.addAttribute("examinations", examinations);

            List<Results> results = this.getResultsByUsername(requestWrapper.getUserPrincipal().getName());
            model.addAttribute("results", results);

            List<ClassifierTable> diagnoses = this.getDiagnosesByUsername(requestWrapper.getUserPrincipal().getName());
            model.addAttribute("diagnoses", diagnoses);

            Patients patient = this.getPatientByUsername(requestWrapper.getUserPrincipal().getName());
            model.addAttribute("patient", patient);

            String fullName = this.getPatientByUsername(requestWrapper.getUserPrincipal().getName()).getName();
            String[] names = fullName.split(" ");

            model.addAttribute("firstName", names[0]);

            return "cabinetAndCheckout/cabinet/cabinet";
        } else {
            return "redirect:/logIn";
        }
    }

    @GetMapping("/checkout/{id}")
    public String checkout(Model model,
                           SecurityContextHolderAwareRequestWrapper requestWrapper,
                           @PathVariable String id){

        if (requestWrapper.isUserInRole("ROLE_USER") || requestWrapper.isUserInRole("ROLE_ADMIN")) {

            if (requestWrapper.getUserPrincipal().getName().equals(this.getByExamId(id).getPatient().getUsername())){
                String fullName = this.getPatientByUsername(requestWrapper.getUserPrincipal().getName()).getName();
                String[] names = fullName.split(" ");

                model.addAttribute("firstName", names[0]);
                model.addAttribute("lastName", names[1]);
                model.addAttribute("service", this.getByExamId(id).getQualification().getName());
                model.addAttribute("examinationId", id);

                return "cabinetAndCheckout/checkout/checkout";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/logIn";
        }
    }

    @PostMapping("/checkout/{id}")
    public String checkout(Model model,
                           @ModelAttribute("examinationId") String examinationId,
                           SecurityContextHolderAwareRequestWrapper requestWrapper){

        Examinations examinations = this.getByExamId(examinationId);
        examinations.setStatus("Оплачено");

        examinationsRepo.save(examinations);

        return "redirect:/cabinet";
    }
}
