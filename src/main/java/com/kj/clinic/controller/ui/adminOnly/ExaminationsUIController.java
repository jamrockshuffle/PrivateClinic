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

import com.kj.clinic.model.*;
import com.kj.clinic.repository.ExaminationsRepo;
import com.kj.clinic.services.dto.ExaminationForm;
import com.kj.clinic.services.dto.ExaminationFormDB;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOUpdate;
import com.kj.clinic.services.service.examinations.ExaminationsServiceImpl;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
import com.kj.clinic.services.service.personnel.PersonnelServiceImpl;
import com.kj.clinic.services.service.qualification.QualificationServiceImpl;
import com.kj.clinic.services.service.qualificationPrices.QualificationPricesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/database/examinations")
@Controller
public class ExaminationsUIController {

    @Autowired
    ExaminationsServiceImpl examinationsService;

    @Autowired
    QualificationServiceImpl qualificationService;

    @Autowired
    PersonnelServiceImpl personnelService;

    @Autowired
    QualificationPricesServiceImpl qualificationPricesService;

    @Autowired
    PatientsServiceImpl patientsService;

    public Patients getByUsername(String username) {
        return patientsService.findAll().stream()
                .filter(item -> item.getUsername()
                        .equals(username))
                .findFirst()
                .orElse(null);
    }

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){

        examinationsService.deleteById(id);

        return "redirect:/database/examinations/find/all";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable String id,
                         final RedirectAttributes redirectAttributes){

        ExaminationFormDB examinationFormDB = new ExaminationFormDB();
        examinationFormDB.setId(id);
        examinationFormDB.setExaminationId(examinationsService.findById(id).getExaminationId());

        String fullName = examinationsService.findById(id).getPatient().getName();
        String[] names = fullName.split(" ");
        examinationFormDB.setFirstName(names[0]);
        examinationFormDB.setLastName(names[1]);

        examinationFormDB.setQualification(examinationsService.findById(id).getQualification().getQualification().getName());
        examinationFormDB.setQualificationPrice(examinationsService.findById(id).getQualification().getName());
        examinationFormDB.setDoctor(examinationsService.findById(id).getDoctor().getName());
        examinationFormDB.setExaminationTime(examinationsService.findById(id).getExaminationTime().toString());
        examinationFormDB.setPrice(examinationsService.findById(id).getPrice().toString());
        examinationFormDB.setStatus(examinationsService.findById(id).getStatus());

        model.addAttribute("examination", examinationFormDB);

        List<Personnel> doctors = new ArrayList<>(personnelService.findAll());
        List<QualificationPrices> services = new ArrayList<>(qualificationPricesService.findAll());


        model.addAttribute("doctors", doctors);
        model.addAttribute("services", services);

        String username = examinationsService.findById(id).getPatient().getUsername();
        model.addAttribute("username", username);

        return "x-database/examinations/examinations-update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @ModelAttribute("examination") ExaminationFormDB examination,
                         @PathVariable String id,
                         @RequestParam String username){

        ExaminationsDTOUpdate examinationsDTOUpdate = new ExaminationsDTOUpdate();
        examinationsDTOUpdate.setId(examination.getId());
        examinationsDTOUpdate.setExaminationId(examination.getExaminationId());
        examinationsDTOUpdate.setPatient(getByUsername(username).getId());
        examinationsDTOUpdate.setDoctor(examination.getDoctor());
        examinationsDTOUpdate.setQualification(examination.getQualificationPrice());
        examinationsDTOUpdate.setExaminationTime(examination.getExaminationTime());

        if (examination.getStatus().equals("")) {
            examinationsDTOUpdate.setStatus(null);
        } else {
            examinationsDTOUpdate.setStatus(examination.getStatus());
        }

        examinationsService.updateUI(examinationsDTOUpdate);

        return "redirect:/database/examinations/find/all";
    }
}
