/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 28.03.23, 21:43
 *  * @Version: IPatientsDAO: 1.0
 *
 */

package com.kj.clinic.services.dao.patients;

import com.kj.clinic.model.Patients;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.dto.patients.PatientsDTOUpdate;

import java.util.List;

public interface IPatientsDAO {
    List<Patients> findAll();
    Patients findById(String id);
    List<Patients> deleteById (String id);
    Patients create (PatientsDTOCreate dtoObj);
    Patients update (PatientsDTOUpdate dtoObj);
    Patients createUI (PatientsDTOCreate dtoObj);
    Patients updateUI (PatientsDTOUpdate dtoObj);
}
