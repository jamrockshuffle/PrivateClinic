/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 22:11
 *  * @Version: ResultsDAOImpl: 1.0
 *
 */

package com.kj.clinic.services.dao.results;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.model.Results;
import com.kj.clinic.repository.ExaminationsRepo;
import com.kj.clinic.repository.PatientsRepo;
import com.kj.clinic.repository.ResultsRepo;
import com.kj.clinic.services.dto.results.ResultsDTOCreate;
import com.kj.clinic.services.dto.results.ResultsDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ResultsDAOImpl implements IResultsDAO{

    @Autowired
    ResultsRepo resultsRepo;

    @Autowired
    PatientsRepo patientsRepo;

    @Autowired
    ExaminationsRepo examinationsRepo;

    public Examinations getExaminationByID(String examinationId) {

        return examinationsRepo.findAll().stream()
                .filter(item -> item.getExaminationId()
                        .equals(examinationId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Results> findAll() {
        return resultsRepo.findAll();
    }

    @Override
    public Results findById(String id) {
        return resultsRepo.findById(id).orElse(null);
    }

    @Override
    public List<Results> deleteById(String id) {
        resultsRepo.deleteById(id);
        return resultsRepo.findAll();
    }

    @Override
    public Results create(ResultsDTOCreate dtoObj) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        Results obj = new Results();
        obj.setId(id);

        obj.setExaminationId(dtoObj.getExaminationId());

        obj.setPatient(this.getExaminationByID(dtoObj.getExaminationId()).getPatient());
        obj.setExaminationDate(this.getExaminationByID(dtoObj.getExaminationId()).getExaminationTime());
        obj.setQualification(this.getExaminationByID(dtoObj.getExaminationId()).getQualification());

        obj.setPrescription(dtoObj.getPrescription());

        resultsRepo.save(obj);
        return obj;

    }

    @Override
    public Results update(ResultsDTOUpdate dtoObj) {

        Results obj = new Results();
        obj.setId(resultsRepo.findById(dtoObj.getId()).get().getId());

        obj.setExaminationId(dtoObj.getExaminationId());

        obj.setPatient(this.getExaminationByID(dtoObj.getExaminationId()).getPatient());
        obj.setExaminationDate(this.getExaminationByID(dtoObj.getExaminationId()).getExaminationTime());
        obj.setQualification(this.getExaminationByID(dtoObj.getExaminationId()).getQualification());

        obj.setPrescription(dtoObj.getPrescription());

        resultsRepo.save(obj);

        return obj;
    }

}
