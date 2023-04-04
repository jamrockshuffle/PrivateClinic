/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:18
 *  * @Version: ExaminationsController: 1.0
 *
 */

package com.kj.clinic.controller.rest;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOUpdate;
import com.kj.clinic.services.service.examinations.ExaminationsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/examinations")
public class ExaminationsController {

    @Autowired
    ExaminationsServiceImpl service;

    @RequestMapping("/find/all")
    public List<Examinations> findAll (){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public Examinations findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public List<Examinations> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PostMapping("/create")
    public Examinations create(@RequestBody ExaminationsDTOCreate dtoObj) {
        return service.create(dtoObj);
    }

    @PostMapping("/update")
    public Examinations update(@RequestBody ExaminationsDTOUpdate dtoObj) {
        return service.update(dtoObj);
    }
}
