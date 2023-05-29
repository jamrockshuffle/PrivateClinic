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

import com.kj.clinic.model.*;
import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import com.kj.clinic.security.model.User;
import com.kj.clinic.security.repository.UserRepository;
import com.kj.clinic.services.dto.PatientsForm;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.dto.patients.PatientsDTOUpdate;
import com.kj.clinic.services.dto.personnel.PersonnelDTOUpdate;
import com.kj.clinic.services.service.illnesses.IllnessesServiceImpl;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/database/patients")
@Controller
public class PatientsUIController {

    @Autowired
    PatientsServiceImpl patientsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IllnessesServiceImpl illnessesService;

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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id,
                         @RequestParam(required = false) String exists,
                         final RedirectAttributes redirectAttributes){

        PatientsForm patientsForm = new PatientsForm();
        patientsForm.setId(id);

        String[] names = patientsService.findById(id).getName().split(" ");
        patientsForm.setFirstName(names[0]);
        patientsForm.setLastName(names[1]);

        patientsForm.setBirthday(patientsService.findById(id).getBirthday().toString());
        patientsForm.setPhone(patientsService.findById(id).getPhone());
        patientsForm.setEmail(patientsService.findById(id).getEmail());
        patientsForm.setIllnesses(patientsService.findById(id).getIllnesses().getName());
        patientsForm.setUsername(patientsService.findById(id).getUsername());

        model.addAttribute("patients", patientsForm);

        List<String> illnesses = illnessesService.findAll()
                .stream()
                .map(Illnesses::getName)
                .collect(Collectors.toList());

        model.addAttribute("illnesses", illnesses);
        redirectAttributes.addFlashAttribute("username", patientsForm.getUsername());

        if (exists != null) {
            return "x-database/patients/patients-update-username-exists";
        } else {
            return "x-database/patients/patients-update";
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @ModelAttribute("patients") PatientsForm patientsForm,
                         @ModelAttribute("username") String username,
                         @PathVariable String id){

        List<String> usernames = userRepository.findAll()
                .stream()
                .map(User::getUsername)
                .collect(Collectors.toList());

        if(usernames.contains(patientsForm.getUsername()) && !patientsForm.getUsername().equals(username)) {
            return "redirect:/database/patients/update/" + patientsForm.getId() + "?exists=true";
        } else {

            PatientsDTOUpdate patientsDTOUpdate = new PatientsDTOUpdate();
            patientsDTOUpdate.setId(patientsForm.getId());
            patientsDTOUpdate.setName(patientsForm.getFirstName() + " " + patientsForm.getLastName());
            patientsDTOUpdate.setBirthday(patientsForm.getBirthday());
            patientsDTOUpdate.setPhone(patientsForm.getPhone());
            patientsDTOUpdate.setEmail(patientsForm.getEmail());
            patientsDTOUpdate.setIllnesses(patientsForm.getIllnesses());
            patientsDTOUpdate.setUsername(patientsForm.getUsername());

            patientsService.updateUI(patientsDTOUpdate);

            return "redirect:/database/patients/find/all";
        }
    }
}