/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:19
 *  * @Version: QualificationController: 1.0
 *
 */

package com.kj.clinic.controller.rest;

import com.kj.clinic.model.Qualification;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;
import com.kj.clinic.services.service.qualification.QualificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/qualification")
public class QualificationController {

    @Autowired
    QualificationServiceImpl service;

    @RequestMapping("/find/all")
    public List<Qualification> findAll (){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public Qualification findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public List<Qualification> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PostMapping("/create")
    public Qualification create(@RequestBody QualificationDTOCreate dtoObj) {
        return service.create(dtoObj);
    }

    @PostMapping("/update")
    public Qualification update(@RequestBody QualificationDTOUpdate dtoObj) {
        return service.update(dtoObj);
    }
}
