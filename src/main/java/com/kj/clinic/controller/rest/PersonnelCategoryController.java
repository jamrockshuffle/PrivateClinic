/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:18
 *  * @Version: PersonnelCategoryController: 1.0
 *
 */

package com.kj.clinic.controller.rest;

import com.kj.clinic.model.Patients;
import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.dto.patients.PatientsDTOUpdate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOCreate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOUpdate;
import com.kj.clinic.services.service.patients.PatientsServiceImpl;
import com.kj.clinic.services.service.personnelCategory.PersonnelCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personnelCategory")
public class PersonnelCategoryController {

    @Autowired
    PersonnelCategoryServiceImpl service;

    @RequestMapping("/find/all")
    public List<PersonnelCategory> findAll (){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public PersonnelCategory findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public List<PersonnelCategory> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PostMapping("/create")
    public PersonnelCategory create(@RequestBody PersonnelCategoryDTOCreate dtoObj) {
        return service.create(dtoObj);
    }

    @PostMapping("/update")
    public PersonnelCategory update(@RequestBody PersonnelCategoryDTOUpdate dtoObj) {
        return service.update(dtoObj);
    }
}
