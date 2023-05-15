/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 22:06
 *  * @Version: ExaminationsDAOImpl: 1.0
 *
 */

package com.kj.clinic.services.dao.examinations;

import com.kj.clinic.model.Examinations;
import com.kj.clinic.model.Patients;
import com.kj.clinic.model.Personnel;
import com.kj.clinic.model.QualificationPrices;
import com.kj.clinic.repository.*;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOCreate;
import com.kj.clinic.services.dto.examinations.ExaminationsDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class ExaminationsDAOImpl implements IExaminationsDAO{

    @Autowired
    ExaminationsRepo examinationsRepo;

    @Autowired
    PatientsRepo patientsRepo;

    @Autowired
    PersonnelRepo personnelRepo;

    @Autowired
    QualificationPricesRepo qualificationPricesRepo;

    public Personnel getByName(String name) {
        return personnelRepo.findAll().stream()
                .filter(item -> item.getName()
                        .equals(name))
                .findFirst()
                .orElse(null);
    }

    public QualificationPrices getByQPrice(String name) {
        return qualificationPricesRepo.findAll().stream()
                .filter(item -> item.getName()
                        .equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Examinations> findAll() {
        return examinationsRepo.findAll();
    }

    @Override
    public Examinations findById(String id) {
        return examinationsRepo.findById(id).orElse(null);
    }

    @Override
    public List<Examinations> deleteById(String id) {
        examinationsRepo.deleteById(id);
        return examinationsRepo.findAll();
    }

    @Override
    public Examinations create(ExaminationsDTOCreate dtoObj) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        Examinations obj = new Examinations();
        obj.setId(id);

        UUID examId = UUID.randomUUID();
        obj.setExaminationId(examId.toString());

        obj.setPatient(patientsRepo.findById(dtoObj.getPatient()).get());
        obj.setDoctor(personnelRepo.findById(dtoObj.getDoctor()).get());
        obj.setQualification(qualificationPricesRepo.findById(dtoObj.getQualification()).get());
        obj.setExaminationTime(LocalDateTime.parse(dtoObj.getExaminationTime()));

        BigDecimal patientDiscount;
        BigDecimal doctorPrice;

        switch (patientsRepo.findById(dtoObj.getPatient()).get().getCategory()) {
            case "II" -> patientDiscount = BigDecimal.valueOf(0.7);
            case "III" -> patientDiscount = BigDecimal.valueOf(0.5);
            default -> patientDiscount = BigDecimal.valueOf(1);
        }

        switch (personnelRepo.findById(dtoObj.getDoctor()).get().getPersonnelCategory().getName()) {
            case "II" -> doctorPrice = BigDecimal.valueOf(1.5);
            case "III" -> doctorPrice = BigDecimal.valueOf(2.0);
            default -> doctorPrice = BigDecimal.valueOf(1);
        }

        BigDecimal finalPrice = qualificationPricesRepo.findById(dtoObj.getQualification()).get().getPrice()
                .multiply(patientDiscount)
                .multiply(doctorPrice);

        obj.setPrice(finalPrice);
        //obj.setStatus("");

        examinationsRepo.save(obj);
        return obj;
    }

    @Override
    public Examinations update(ExaminationsDTOUpdate dtoObj) {
        Examinations obj = new Examinations();

        obj.setId(examinationsRepo.findById(dtoObj.getId()).get().getId());

        obj.setExaminationId(dtoObj.getExaminationId());

        obj.setPatient(patientsRepo.findById(dtoObj.getPatient()).get());
        obj.setDoctor(personnelRepo.findById(dtoObj.getDoctor()).get());
        obj.setQualification(qualificationPricesRepo.findById(dtoObj.getQualification()).get());
        obj.setExaminationTime(LocalDateTime.parse(dtoObj.getExaminationTime()));

        BigDecimal patientDiscount;
        BigDecimal doctorPrice;

        switch (patientsRepo.findById(dtoObj.getPatient()).get().getCategory()) {
            case "II" -> patientDiscount = BigDecimal.valueOf(0.7);
            case "III" -> patientDiscount = BigDecimal.valueOf(0.5);
            default -> patientDiscount = BigDecimal.valueOf(1);
        }

        switch (personnelRepo.findById(dtoObj.getDoctor()).get().getPersonnelCategory().getName()) {
            case "II" -> doctorPrice = BigDecimal.valueOf(1.5);
            case "III" -> doctorPrice = BigDecimal.valueOf(2.0);
            default -> doctorPrice = BigDecimal.valueOf(1);
        }

        BigDecimal finalPrice = qualificationPricesRepo.findById(dtoObj.getQualification()).get().getPrice()
                .multiply(patientDiscount)
                .multiply(doctorPrice);

        obj.setPrice(finalPrice);
        obj.setStatus(examinationsRepo.findById(dtoObj.getId()).get().getStatus());

        examinationsRepo.save(obj);
        return obj;
    }

    @Override
    public Examinations createUI(ExaminationsDTOCreate dtoObj) {

        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        Examinations obj = new Examinations();
        obj.setId(id);

        UUID examId = UUID.randomUUID();
        obj.setExaminationId(examId.toString());

        obj.setPatient(patientsRepo.findById(dtoObj.getPatient()).get());
        obj.setDoctor(this.getByName(dtoObj.getDoctor()));
        obj.setQualification(this.getByQPrice(dtoObj.getQualification()));
        obj.setExaminationTime(LocalDateTime.parse(dtoObj.getExaminationTime()));

        BigDecimal patientDiscount;
        BigDecimal doctorPrice;

        switch (patientsRepo.findById(dtoObj.getPatient()).get().getCategory()) {
            case "II" -> patientDiscount = BigDecimal.valueOf(0.7);
            case "III" -> patientDiscount = BigDecimal.valueOf(0.5);
            default -> patientDiscount = BigDecimal.valueOf(1);
        }

        switch (this.getByName(dtoObj.getDoctor()).getPersonnelCategory().getName()) {
            case "II" -> doctorPrice = BigDecimal.valueOf(1.5);
            case "III" -> doctorPrice = BigDecimal.valueOf(2.0);
            default -> doctorPrice = BigDecimal.valueOf(1);
        }

        BigDecimal finalPrice = this.getByQPrice(dtoObj.getQualification()).getPrice()
                .multiply(patientDiscount)
                .multiply(doctorPrice);

        obj.setPrice(finalPrice);

        examinationsRepo.save(obj);
        return obj;
    }
}
