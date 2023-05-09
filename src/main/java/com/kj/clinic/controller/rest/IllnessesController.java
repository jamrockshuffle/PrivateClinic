/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 13:13
 *  * @Version: IllnessesController: 1.0
 *
 */

package com.kj.clinic.controller.rest;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.model.Illnesses;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOUpdate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOCreate;
import com.kj.clinic.services.dto.illnesses.IllnessesDTOUpdate;
import com.kj.clinic.services.service.illnesses.IllnessesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/illnesses")
public class IllnessesController {

    @Autowired
    IllnessesServiceImpl service;

    @RequestMapping("/find/all")
    public List<Illnesses> findAll (){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public Illnesses findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public List<Illnesses> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PostMapping("/create")
    public Illnesses create(@RequestBody IllnessesDTOCreate dtoObj) {
        return service.create(dtoObj);
    }

    @PostMapping("/update")
    public Illnesses update(@RequestBody IllnessesDTOUpdate dtoObj) {
        return service.update(dtoObj);
    }
}
