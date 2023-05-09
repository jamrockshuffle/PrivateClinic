/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:18
 *  * @Version: PatientsController: 1.0
 *
 */

package com.kj.clinic.controller.rest;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.model.Patients;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOUpdate;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.dto.patients.PatientsDTOUpdate;
import com.kj.clinic.services.service.examinations.ExaminationsServiceImpl;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("api/patients")
public class PatientsController {

    @Autowired
    PatientsServiceImpl service;

    @RequestMapping("/find/all")
    public List<Patients> findAll (){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public Patients findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public List<Patients> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PostMapping("/create")
    public Patients create(@RequestBody PatientsDTOCreate dtoObj) {
        return service.create(dtoObj);
    }

    @PostMapping("/update")
    public Patients update(@RequestBody PatientsDTOUpdate dtoObj) {
        return service.update(dtoObj);
    }
}