/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:19
 *  * @Version: ResultsController: 1.0
 *
 */

package com.kj.clinic.controller.rest;

import com.kj.clinic.model.Results;
import com.kj.clinic.services.dto.results.ResultsDTOCreate;
import com.kj.clinic.services.dto.results.ResultsDTOUpdate;
import com.kj.clinic.services.service.results.ResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("api/results")
public class ResultsController {

    @Autowired
    ResultsServiceImpl service;

    @RequestMapping("/find/all")
    public List<Results> findAll (){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public Results findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public List<Results> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PostMapping("/create")
    public Results create(@RequestBody ResultsDTOCreate dtoObj) {
        return service.create(dtoObj);
    }

    @PostMapping("/update")
    public Results update(@RequestBody ResultsDTOUpdate dtoObj) {
        return service.update(dtoObj);
    }
}
