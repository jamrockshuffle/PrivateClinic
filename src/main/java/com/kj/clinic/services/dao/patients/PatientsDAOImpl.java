/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:44
 *  * @Version: PatientsDAOImpl: 1.0
 *
 */

package com.kj.clinic.services.dao.patients;

import com.kj.clinic.model.Patients;
import com.kj.clinic.model.Personnel;
import com.kj.clinic.repository.PatientsRepo;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.dto.patients.PatientsDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PatientsDAOImpl implements IPatientsDAO{

    @Autowired
    PatientsRepo repository;

    @Override
    public List<Patients> findAll() {
        return repository.findAll();
    }

    @Override
    public Patients findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Patients> deleteById(String id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    @Override
    public Patients create(PatientsDTOCreate dtoObj) {
        String id = String.valueOf(this.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        Patients obj = new Patients();
        obj.setId(id);
        obj.setName(dtoObj.getName());
        obj.setBirthday(LocalDate.parse(dtoObj.getBirthday()));
        obj.setPhone(dtoObj.getPhone());
        obj.setEmail(dtoObj.getEmail());

        obj.setIllnesses(dtoObj.getIllnesses());

        switch (dtoObj.getIllnesses()) {
            case "Chronic" -> obj.setCategory("II");
            case "Disability" -> obj.setCategory("III");
            default -> obj.setCategory("I");
        }

        // USERNAME DO AFTER SECURITY
        obj.setUsername(" ");

        repository.save(obj);
        return obj;
    }

    @Override
    public Patients update(PatientsDTOUpdate dtoObj) {
        Patients obj = new Patients();

        obj.setId(repository.findById(dtoObj.getId()).get().getId());

        obj.setName(dtoObj.getName());
        obj.setBirthday(LocalDate.parse(dtoObj.getBirthday()));
        obj.setPhone(dtoObj.getPhone());
        obj.setEmail(dtoObj.getEmail());

        obj.setIllnesses(dtoObj.getIllnesses());

        switch (dtoObj.getIllnesses()) {
            case "Chronic" -> obj.setCategory("II");
            case "Disability" -> obj.setCategory("III");
            default -> obj.setCategory("I");
        }

        // USERNAME DO AFTER SECURITY
        obj.setUsername(" ");

        repository.save(obj);
        return obj;
    }
}
