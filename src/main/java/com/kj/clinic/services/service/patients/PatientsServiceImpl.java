/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:06
 *  * @Version: PatientsServiceImpl: 1.0
 *
 */

package com.kj.clinic.services.service.patients;

import com.kj.clinic.model.Patients;
import com.kj.clinic.services.dao.patients.PatientsDAOImpl;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.dto.patients.PatientsDTOUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientsServiceImpl implements IPatientsService{

    @Autowired
    PatientsDAOImpl dao;

    @Override
    public List<Patients> findAll() {
        return dao.findAll();
    }

    @Override
    public Patients findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Patients> deleteById(String id) {
        return dao.deleteById(id);
    }

    @Override
    public Patients create(PatientsDTOCreate dtoObj) {
        return dao.create(dtoObj);
    }

    @Override
    public Patients createUI(PatientsDTOCreate dtoObj) {
        return dao.createUI(dtoObj);
    }

    @Override
    public Patients update(PatientsDTOUpdate dtoObj) {
        return dao.update(dtoObj);
    }
}
