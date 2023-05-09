/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:06
 *  * @Version: IPatientsService: 1.0
 *
 */

package com.kj.clinic.services.service.patients;

import com.kj.clinic.model.Patients;
import com.kj.clinic.services.dto.patients.PatientsDTOCreate;
import com.kj.clinic.services.dto.patients.PatientsDTOUpdate;

import java.util.List;

public interface IPatientsService {
    List<Patients> findAll();
    Patients findById(String id);
    List<Patients> deleteById (String id);
    Patients create (PatientsDTOCreate dtoObj);
    Patients createUI (PatientsDTOCreate dtoObj);
    Patients update (PatientsDTOUpdate dtoObj);


}
