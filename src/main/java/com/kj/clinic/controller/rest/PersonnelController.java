/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:18
 *  * @Version: PersonnelController: 1.0
 *
 */

package com.kj.clinic.controller.rest;

import com.kj.clinic.model.Personnel;
import com.kj.clinic.model.PersonnelCategory;
import com.kj.clinic.services.dto.personnel.PersonnelDTOCreate;
import com.kj.clinic.services.dto.personnel.PersonnelDTOUpdate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOCreate;
import com.kj.clinic.services.dto.personnelCategory.PersonnelCategoryDTOUpdate;
import com.kj.clinic.services.service.personnel.PersonnelServiceImpl;
import com.kj.clinic.services.service.personnelCategory.PersonnelCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("api/personnel")
public class PersonnelController {

    @Autowired
    PersonnelServiceImpl service;

    @RequestMapping("/find/all")
    public List<Personnel> findAll (){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public Personnel findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public List<Personnel> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PostMapping("/create")
    public Personnel create(@RequestBody PersonnelDTOCreate dtoObj) {
        return service.create(dtoObj);
    }

    @PostMapping("/update")
    public Personnel update(@RequestBody PersonnelDTOUpdate dtoObj) {
        return service.update(dtoObj);
    }
}

