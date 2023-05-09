/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 05.05.23, 13:14
 *  * @Version: QualificationPricesController: 1.0
 *
 */

package com.kj.clinic.controller.rest;


import com.kj.clinic.model.QualificationPrices;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOCreate;
import com.kj.clinic.services.dto.qualificationPrices.QualificationPricesDTOUpdate;
import com.kj.clinic.services.service.qualificationPrices.QualificationPricesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/qualificationPrices")
public class QualificationPricesController {

    @Autowired
    QualificationPricesServiceImpl service;

    @RequestMapping("/find/all")
    public List<QualificationPrices> findAll (){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public QualificationPrices findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public List<QualificationPrices> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

    @PostMapping("/create")
    public QualificationPrices create(@RequestBody QualificationPricesDTOCreate dtoObj) {
        return service.create(dtoObj);
    }

    @PostMapping("/update")
    public QualificationPrices update(@RequestBody QualificationPricesDTOUpdate dtoObj) {
        return service.update(dtoObj);
    }
}
