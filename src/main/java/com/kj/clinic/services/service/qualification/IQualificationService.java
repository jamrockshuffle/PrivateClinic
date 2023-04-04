/*
 * *
 *  * Created by IntelliJ IDEA.
 *  *
 *  * @Author: Mykola Bidiuk
 *  * @Date: 29.03.23, 14:07
 *  * @Version: IQualificationsService: 1.0
 *
 */

package com.kj.clinic.services.service.qualification;

import com.kj.clinic.model.Qualification;
import com.kj.clinic.services.dto.qualification.QualificationDTOCreate;
import com.kj.clinic.services.dto.qualification.QualificationDTOUpdate;

import java.util.List;

public interface IQualificationService {
    List<Qualification> findAll();
    Qualification findById(String id);
    List<Qualification> deleteById (String id);
    Qualification create (QualificationDTOCreate dtoObj);
    Qualification update (QualificationDTOUpdate dtoObj);
}
